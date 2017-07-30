package adressorgula;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by MhmdAlmz on 30.07.2017.
 */

public class Sorgula implements ISorgula {

    public ArrayList<Adres> lokasyonAdressGetir(double latitude, double longitute){

        ArrayList<Adres> adresArrayList=new ArrayList<>();
        HttpGet httpGet = new HttpGet(
                "http://maps.google.com/maps/api/geocode/json?address="
                        + latitude+","+longitute + "&ka&sensor=false");
        HttpClient client = new DefaultHttpClient();
        HttpResponse response;
        String httpJSONSonuc="";
        try {
            response = client.execute(httpGet);
            HttpEntity entity = response.getEntity();
             httpJSONSonuc=EntityUtils.toString( entity, HTTP.UTF_8 );
        } catch (Exception e){
            e.printStackTrace();
            return null;
        }

        try {
            JSONObject jsonObjectResult = new JSONObject(httpJSONSonuc);
            if(!jsonObjectResult.getString("status").equals("OK"))
            {
                throw new SorgulaException(jsonObjectResult.getString("status"));
            }else{
                JSONArray jsonArrayResults=jsonObjectResult.getJSONArray("results");
                for(int i =0;i<jsonArrayResults.length();i++)
                {
                    Adres adres=new Adres();
                    JSONObject jsonObjectAdress=jsonArrayResults.getJSONObject(i);
                    adres.setAcikAdres(jsonObjectAdress.getString("formatted_address"));
                    adres.setTip(tipGetir(jsonObjectAdress));
                    JSONArray jsonArrayAdressComponents=jsonObjectAdress.getJSONArray("address_components");
                    for(int j=0;j<jsonArrayAdressComponents.length();j++)
                    {
                        JSONObject jsonObjectAdressComponents=jsonArrayAdressComponents.getJSONObject(j);
                        if(tipGetir(jsonObjectAdressComponents).equals("street_number"))
                        {
                            adres.setNumara(jsonObjectAdressComponents.getString("long_name"));
                        }else if(tipGetir(jsonObjectAdressComponents).equals("route"))
                        {
                            adres.setSokak(jsonObjectAdressComponents.getString("long_name"));
                        }else if(tipGetir(jsonObjectAdressComponents).equals("administrative_area_level_2"))
                        {
                            adres.setIlce(jsonObjectAdressComponents.getString("long_name"));
                        }else if(tipGetir(jsonObjectAdressComponents).equals("administrative_area_level_4"))
                        {
                            adres.setMahalle(jsonObjectAdressComponents.getString("long_name"));
                        }else if(tipGetir(jsonObjectAdressComponents).equals("administrative_area_level_1"))
                        {
                            adres.setIl(jsonObjectAdressComponents.getString("long_name"));
                        }else if(tipGetir(jsonObjectAdressComponents).equals("country"))
                        {
                            adres.setUlke(jsonObjectAdressComponents.getString("long_name"));
                        }else if(tipGetir(jsonObjectAdressComponents).equals("postal_code"))
                        {
                            adres.setPostaKodu(Integer.parseInt(jsonObjectAdressComponents.getString("long_name")));
                        }else if(tipGetir(jsonObjectAdressComponents).equals("street_number"))
                        {
                            adres.setIl(jsonObjectAdressComponents.getString("long_name"));
                        }

                    }
                    adresArrayList.add(adres);
                }


            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return adresArrayList;
    }

    @Override
    public String tipGetir(JSONObject jsonObjectTip) throws Exception {

       return jsonObjectTip.getJSONArray("types").getString(0);
    }
}

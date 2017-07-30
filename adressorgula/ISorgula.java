package adressorgula;

import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by MhmdAlmz on 30.07.2017.
 */

public interface ISorgula {
    public ArrayList<Adres> lokasyonAdressGetir(double latitude,double longitute);
    public String tipGetir(JSONObject jsonObjectTip) throws Exception;
}

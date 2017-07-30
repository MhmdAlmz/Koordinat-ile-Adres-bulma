# Koordinat-ile-adres-bulma

Elinizde bulunan koordinatların hangi adres'e ait olduğunu bulmak için şu adres'i ziyaret ederek detaylı bilgi alabilirsiniz.

LINK : https://developers.google.com/maps/documentation/geocoding/intro

Elinizde bulunan koordinatın bulunduğu muhtemel adresleri bir ArrayList içerisinde atarak sonuç alabilirsiniz.

# ÖRNEK 

```
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
         adressGetir(new Sorgula().lokasyonAdressGetir(41.082536, 29.005298));
    }
    
    public  void adressGetir(ArrayList<Adres> arrayListAdres ) {
        Log.e("Adres", "address  :  " + arrayListAdres.get(0).getAcikAdres());
        Log.e("Adres", "il  :  " + arrayListAdres.get(0).getIl());
        Log.e("Adres", "ilce  :  " + arrayListAdres.get(0).getIlce());
        Log.e("Adres", "Mahalle  :  " + arrayListAdres.get(0).getMahalle());
        Log.e("Adres", "Sokak  :  " + arrayListAdres.get(0).getSokak());
        Log.e("Adres", "Ulke  :  " + arrayListAdres.get(0).getUlke());
        Log.e("Adres", "PostaKodu  :  " + arrayListAdres.get(0).getPostaKodu());
    }
    
```

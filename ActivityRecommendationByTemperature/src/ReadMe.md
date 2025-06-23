Uygulama https://api.collectapi.com/weather/getWeather endpointinden şehir(1) bazlı bugünkü güncel hava durumunu
çekip dönen json formatında result node adındaki response bodydeki dizinin ilk elemanındaki description ve degree
alan değerlerine göre aktivite önerisi yapmaktadır.

1' in öncesindeki işlemler;
1. işlem --> Türkiye' nin şehirlerini baş harfi büyük ve Türkçe karakterli şekilde bir String listesine alıp bu listedeki elemanları
sırayla bir karakter dizisine alıp karakter dizisindeki her karakter için Türkçe karakteri İngilizce formatına dönüştürüp
sonra olarak oluşan güncel karakter dizisini stringe dönüştürüp tüm karakterleri küçültür.

2. işlem --> Daha sonra bir map ile "Adıyaman","adiyaman" formatında key ve value şeklinde tutulur.
{3.} 1. ve 2. işlemler değer döndürmeyen bir metot içine alınıp atılacak isteğe uygun parametre valuesu olması için API kullanma
kodları öncesinde çağırılır.

şehir(1) --> İstekte kullanılacak şehir valuesu için kullanıcıdan String formatında değer alınır.
Pattern validasyonu yapılmadan {3.} işlemi yapıldıktan sonra if else mantığı ile istek kodlarının implementasyonuna devam edilir.
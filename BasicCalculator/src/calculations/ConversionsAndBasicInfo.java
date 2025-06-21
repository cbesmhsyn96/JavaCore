package calculations;

public class ConversionsAndBasicInfo {
    /*
    Sayının görünümünü veya temsil biçimini değiştiren işlemler.
    Alt işlemler:
    Ondalık yuvarlama (Math.round, ceil, floor)
    Binary/hex/decimal dönüşüm (Integer.toBinaryString(x))
    İşaret kontrolü (Math.signum(x))
     */
    /*
    | Metot           | Açıklama                       | Örnek                     |
| --------------- | ------------------------------ | ------------------------- |
| `Math.round(x)` | En yakın tamsayıya yuvarlar    | `Math.round(3.6)` → `4`   |
| `Math.ceil(x)`  | Yukarı yuvarlar (tavana doğru) | `Math.ceil(3.2)` → `4.0`  |
| `Math.floor(x)` | Aşağı yuvarlar (zemine doğru)  | `Math.floor(3.9)` → `3.0` |

| İşlem            | Metot / Örnek                           |
| ---------------- | --------------------------------------- |
| Ondalık → Binary | `Integer.toBinaryString(10)` → `"1010"` |
| Ondalık → Hex    | `Integer.toHexString(255)` → `"ff"`     |
| Ondalık → Octal  | `Integer.toOctalString(64)` → `"100"`   |
| Binary → Ondalık | `Integer.parseInt("1010", 2)` → `10`    |
| Hex → Ondalık    | `Integer.parseInt("ff", 16)` → `255`    |
| Octal → Ondalık  | `Integer.parseInt("100", 8)` → `64`     |

Math.signum(double x)
| İşlem Türü      | Metot / Fonksiyon            | Açıklama                               |
| --------------- | ---------------------------- | -------------------------------------- |
| Yuvarlama       | `round`, `ceil`, `floor`     | Sayıyı en yakına, yukarı/aşağı yuvarla |
| Sistem dönüşümü | `toBinaryString`, `parseInt` | Sayı tabanları arası dönüşüm           |
| İşaret kontrolü | `signum`                     | Sayı pozitif mi, negatif mi, sıfır mı  |

     */
}
## 🇹🇷TR
# Harf Frekansı Sayacı (Letter Frequency Counter)

Kullanıcıdan bir cümle alıp içindeki harflerin frekansını hesaplayan basit bir Java uygulamasıdır. Bu program; modülerlik, paket kullanımı ve sınıf tabanlı tasarım gibi Java programlamanın temel kavramlarını göstermektedir.

---

## 📦 Proje Yapısı

| Dosya Yolu                            | Açıklama                                |
| ------------------------------------- | --------------------------------------- |
| `src/Runner.java`                     | Programın ana giriş noktası             |
| `src/vars/Defines.java`               | Uygulamada kullanılan sabitleri içerir  |
| `src/lettercounts/LetterCounter.java` | Harf sayma mantığını içerir             |
| `src/display/DisplayCounts.java`      | Harf frekanslarını kullanıcıya gösterir |

---

## 🧠 Nasıl Çalışır?

1. Program kullanıcıdan bir cümle girmesini ister.
2. Eğer girişte harf olmayan karakterler varsa, yalnızca harf (A–Z, a–z) içeren geçerli bir giriş yapılana kadar kullanıcıdan tekrar giriş istenir.
3. Geçerli bir giriş alındıktan sonra, her bir alfabetik harfin (A–Z) kaç kez geçtiği hesaplanır.
4. Harf olmayan karakterler (boşluk, noktalama, rakamlar, semboller vb.) yok sayılır.
5. Büyük/küçük harf ayrımı yapılmaz.
6. Her harfin frekansı alfabetik sıraya göre ekrana yazdırılır.

---

## ▶️ Nasıl Çalıştırılır?

1. `src` klasörü altındaki tüm `.java` dosyalarını derleyin:

   ```bash
   javac src/**/*.java
   ```

2. Ana sınıfı çalıştırın:

   ```bash
   java -cp src Runner
   ```

---

## 📌 Özellikler

* Yalnızca alfabetik karakterler (A–Z, a–z) sayılır.
* Boşluklar, rakamlar, noktalama ve özel karakterler göz ardı edilir.
* A–Z harflerinin frekanslarını büyük/küçük harf duyarsız şekilde gösterir.
* Mantık, görüntüleme ve sabitler için ayrı paketler kullanılarak temiz bir kod yapısı sağlanır.

---

## 🔧 Gereksinimler

* Java JDK 8 veya üzeri
* Bir terminal veya komut satırı arayüzü


---
## 🇬🇧EN
# Letter Frequency Counter
A simple Java application that reads a sentence and calculates the frequency of each letter in it. The program demonstrates basic concepts of Java programming such as modularity, package usage, and class-based design.

## 📦 Project Structure

| File Path                             | Description                                |
| ------------------------------------- | ------------------------------------------ |
| `src/Runner.java`                     | Main entry point of the program            |
| `src/vars/Defines.java`               | Contains constants used in the application |
| `src/lettercounts/LetterCounter.java` | Handles the logic for counting letters     |
| `src/display/DisplayCounts.java`      | Displays letter frequencies to the user    |



## 🧠 How It Works

1. The program prompts the user to enter a sentence.
2. If the input contains non-letter characters, the program repeatedly asks the user to enter a valid input that contains only alphabetic letters (A–Z, a–z).
3. Once a valid input is received, it counts how many times each alphabetic letter (A–Z) appears.
4. Non-letter characters (spaces, punctuation, digits, symbols, etc.) are ignored.
5. The counting is case-insensitive.
6. The frequency of each letter is displayed in alphabetical order.

## ▶️ How to Run

1. Compile all `.java` files under the `src` folder:
   ```bash
   javac src/**/*.java

## Run the main class:
java -cp src Runner

📌 Features
- Only alphabetic characters (A–Z, a–z) are counted.
- Spaces, digits, punctuation, and special characters are ignored.
- Displays the frequencies of letters A–Z in a case-insensitive manner.
- Uses a clean code structure with separate packages for logic, display, and constants.

🔧 Requirements
- Java JDK 8 or higher
- A terminal or command line interface
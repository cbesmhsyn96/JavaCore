# MatrixCalculation

Bu proje, çeşitli matris işlemlerini gerçekleştirmek için oluşturulmuş modüler bir Java uygulamasıdır. Nesne yönelimli programlama prensiplerine uygun olarak yapılandırılmıştır ve `initialize`, `display` ve `matrixcalcs` gibi paketler halinde organize edilmiştir.

---

## 🚀 Özellikler
- Matris Başlatma (kullanıcıdan giriş alınarak)
- Biçimlendirilmiş şekilde Matris Gösterimi
- Matris Transpozu
- Geliştirilmek üzere hazırlanan altyapı:
    - Matris Toplama
    - Matris Çarpımı
    - Skaler ile Çarpma
    - Birim Matris Oluşturma
    - Simetriklik Kontrolü

---

## 📁 Proje Yapısı
| Dosya Yolu                                 |              Açıklama              |
|:-------------------------------------------|:----------------------------------:|
| **MatrixCalculation/src/Runner.java**       |    `Uygulamanın çalıştırma noktası`     |
| **MatrixCalculation/src/vars/Defines.java** | `Global değişkenler ve paylaşılan nesneler` |
| **MatrixCalculation/src/initialize/InitializeMatrix.java** | `Matrisi başlatma ve kullanıcıdan veri alma işlemleri` |
| **MatrixCalculation/src/display/DisplayMatrix.java**         | `Matrisi konsola yazdırma işlemleri` |
| **MatrixCalculation/src/matrixcalcs/MatrixCalculation.java** | `Transpoz ve diğer matris işlemlerini gerçekleştiren sınıf` |



# MatrixCalculation

This is a modular Java application for performing various matrix operations. The project is structured using object-oriented principles and organized in packages such as initialization, display, and calculation logic.

---

## 🚀 Features
- Matrix Initialization (from user input)
- Matrix Display in formatted output
- Matrix Transpose
- Framework prepared for:
    - Matrix Addition
    - Matrix Multiplication
    - Scalar Multiplication
    - Identity Matrix
    - Symmetry Check

---

## 📁 Project Structure
| File                                        |               Dessription               |
|:--------------------------------------------|:---------------------------------------:|
| **MatrixCalculation/src/Runner.java**       |    `Entry point of the application`     |
| **MatrixCalculation/src/vars/Defines.java** | `Global variables and shared instances` |
| **MatrixCalculation/src/initialize/InitializeMatrix.java**        |                   `Handles matrix input/creation`                    |
| **MatrixCalculation/src/display/DisplayMatrix.java**        |                   `Displays matrix in console`                    |
| **MatrixCalculation/src/matrixcalcs/MatrixCalculation.java**        |                   `Performs transpose and matrix-related operations`                    |

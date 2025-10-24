# 📱 Responsi1MobileH1D023032

## 🏟️ Deskripsi Proyek
Aplikasi **Android native** berbasis **Kotlin** yang menampilkan informasi klub sepak bola secara **real-time** dari **API eksternal**. Informasi mencakup sejarah klub, daftar pemain, dan data pelatih.  
Aplikasi menggunakan arsitektur **berlapis (UI & Data)** dengan **Retrofit** untuk koneksi HTTP dan **Gson** untuk parsing JSON. Tampilan dibuat dengan **AndroidX** dan **Material Design** menggunakan `ConstraintLayout` dan `CardView`.

---

## 🧩 Fitur Utama
- Menampilkan **sejarah klub sepak bola**  
- Menampilkan **daftar pemain (skuad)**  
- Menampilkan **informasi pelatih**

---

## 🏗️ Arsitektur Singkat
Aplikasi ini mengikuti **layered architecture** untuk memisahkan logika dan tampilan.

### UI Layer
- **Activities:** `MainActivity`, `ClubHistoryActivity`, `TeamSquadActivity`, `CoachActivity`  
- **Layout:** XML dengan **ConstraintLayout** & **CardView**  
- **Adapter:** `PlayerAdapter.kt` digunakan bersama **RecyclerView** untuk menampilkan daftar pemain  

### Data Layer
- **Model:** `Team.kt`, `Player.kt`, `Coach.kt` sebagai representasi data dari API  
- **API:**  
  - `ApiServices.kt` → mendefinisikan endpoint  
  - `ApiClient.kt` → konfigurasi Retrofit & Gson  

---

## 🔁 Alur Singkat
1. Pengguna membuka **MainActivity**  
2. Memilih klub → pindah ke Activity terkait  
3. Activity memanggil API menggunakan **Retrofit**  
4. JSON dikonversi ke objek Kotlin dengan **Gson**  
5. Data ditampilkan di **UI (TextView, RecyclerView, ImageView)**  

---

## ⚙️ Dependensi Utama
| Library | Fungsi |
|----------|--------|
| Retrofit | Koneksi REST API |
| Converter-Gson | Parsing JSON ke Kotlin |
| AppCompat | Kompatibilitas UI |
| Material | Komponen Material Design |
| ConstraintLayout | Layout responsif |

---

## 🔗 Link Demo
Kamu dapat melihat demo aplikasi melalui tautan berikut:  
<img src="https://github.com/alpaenf/Responsi_PrakPemob_H1D023032/blob/main/app/src/main/res/drawable/demo_responsi%20(1).gif" width="250">

---

# Tugas Pertemuan 2 - Kotlin Model Data (Katalog Produk)
**Nama:** Martio Chandra
**NIM:** 0102524723
**Program Studi:** Informatika, Universitas Al Azhar Indonesia

## Tujuan
Program ini bertujuan untuk mengelola data katalog produk sederhana. Sistem dapat menyaring produk berdasarkan kategori tertentu, memastikan ketersediaan stok, dan menghitung harga akhir setelah potongan diskon.

## Model Data
Menggunakan `data class Produk` yang memiliki 6 properti. Properti `diskon` diatur sebagai *nullable* (`Double?`) karena tidak semua produk memiliki promo diskon.

## Logika Program
1. **Validasi:** Menyaring produk yang harganya valid (>0), nama tidak kosong, dan stok rasional (>=0).
2. **Filter & Sort:** Mengambil produk kategori "Aksesoris" yang stoknya lebih dari 0, lalu diurutkan dari harga termurah.
3. **Map & Null Safety:** Menghitung harga akhir. Jika `diskon` bernilai null, program menggunakan Elvis Operator (`?:`) untuk memberikan nilai *default* 0.0 agar program tidak *crash*.

## Catatan Kesulitan & Solusi
Bagian tersulit dari tugas ini adalah saat mencoba menjalankan fungsi main() murni di dalam modul :app Android Studio, yang memunculkan error "SourceSet with name 'main' not found". Sistem build Android saat ini rupanya membatasi eksekusi langsung fungsi Kotlin murni di dalam struktur proyek aplikasi. Solusi yang saya terapkan adalah mengubah nama fungsi tersebut menjadi fungsi biasa, memanggilnya dari dalam siklus onCreate di MainActivity.kt, dan memantau hasil output teksnya melalui jendela Logcat.
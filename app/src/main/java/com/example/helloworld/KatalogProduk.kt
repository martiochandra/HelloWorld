package com.example.helloworld

// 1. MODEL DATA
// Memenuhi syarat: Minimal 4 properti dan minimal 1 properti nullable
data class Produk(
    val id: String,
    val nama: String,
    val kategori: String,
    val harga: Double,
    val stok: Int,
    val diskon: Double? // Properti nullable (persentase diskon, bernilai null jika tidak ada diskon)
)

fun jalankankatalog() {
    // 2. MINIMAL DATA (8 Item)
    val katalog = listOf(
        Produk("P01", "Laptop Gaming", "Elektronik", 15000000.0, 5, 0.10), // Diskon 10%
        Produk("P02", "Mouse Wireless", "Aksesoris", 150000.0, 50, null),  // Tidak ada diskon (null)
        Produk("P03", "Keyboard Mekanikal", "Aksesoris", 600000.0, 15, 0.05),
        Produk("P04", "Monitor 24 Inch", "Elektronik", 2000000.0, 0, null), // Stok habis
        Produk("P05", "Flashdisk 64GB", "Penyimpanan", 85000.0, 100, null),
        Produk("P06", "Headset Bluetooth", "Aksesoris", 350000.0, 20, 0.15),
        Produk("P07", "Kabel HDMI", "Aksesoris", 50000.0, 30, null),
        Produk("P08", "SSD 1TB", "Penyimpanan", 1200000.0, 10, 0.20)
    )

    // 3. VALIDASI INPUT
    // Mensimulasikan validasi: Memastikan data produk masuk akal (harga tidak minus, nama tidak kosong)
    val dataValid = katalog.filter { produk ->
        produk.harga > 0 && produk.nama.isNotBlank() && produk.stok >= 0
    }

    // 4. PENGOLAHAN DATA (Filter, Sort, Transform/Map)
    // Skenario Logika: Kita ingin mencari produk Aksesoris yang masih ada stok,
    // diurutkan dari harga termurah, lalu diubah formatnya untuk ditampilkan.

    val produkOlahan = dataValid
        .filter { it.kategori == "Aksesoris" && it.stok > 0 } // FILTER: Hanya Aksesoris yang ada stok
        .sortedBy { it.harga }                                // SORT: Urutkan dari harga termurah
        .map { produk ->                                      // TRANSFORM / MAP: Ubah objek jadi String

            // PENERAPAN NULL SAFETY (Mendapat porsi nilai 25%)
            // Menggunakan Elvis operator (?:) untuk menangani nilai null pada diskon.
            // Jika diskon null, maka dianggap 0.0
            val nilaiDiskon = produk.diskon ?: 0.0
            val hargaAkhir = produk.harga - (produk.harga * nilaiDiskon)

            // Format teks (String Template)
            val persenDiskon = (nilaiDiskon * 100).toInt()
            "${produk.nama} | Harga Asli: Rp${produk.harga.toInt()} | Diskon: $persenDiskon% | Harga Akhir: Rp${hargaAkhir.toInt()}"
        }

    // 5. OUTPUT TERFORMAT
    println("=== DAFTAR PRODUK AKSESORIS TERMURAH (TERSEDIA) ===")
    if (produkOlahan.isEmpty()) {
        println("Tidak ada produk yang sesuai kriteria.")
    } else {
        produkOlahan.forEachIndexed { index, info ->
            println("${index + 1}. $info")
        }
    }
}
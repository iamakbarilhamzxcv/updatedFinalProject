Pengujian Otomatis untuk Website Demoblaze dan API Dummy

Deskripsi Proyek

Proyek ini adalah framework otomatisasi pengujian untuk menguji website Demoblaze dan API Dummy. Framework ini menggunakan Cucumber yang diintegrasikan dengan JUnit untuk menguji berbagai fitur pada aplikasi web dan API.

Untuk pengujian website, framework ini menguji sistem login, interaksi produk, pengelolaan keranjang belanja, proses checkout, pemutaran video, pengiriman pesan, dan logout. Sementara untuk pengujian API, dilakukan pengujian terhadap operasi CRUD (Create, Read, Update, Delete) pada data pengguna.

Framework ini dirancang untuk meningkatkan keandalan dan stabilitas aplikasi dengan memastikan bahwa setiap fitur bekerja sesuai harapan dan memberikan umpan balik yang cepat jika terjadi kesalahan.

-------------------------------------------------------------

Struktur Proyek

Struktur proyek ini terdiri dari beberapa direktori utama. Direktori src/test/java/ berisi folder stepDefWeb/ dan stepDefApi/ yang digunakan untuk mendefinisikan langkah-langkah pengujian web dan API. Folder runner/ di dalamnya menyimpan file CucumberTestWeb.java dan CucumberTestApi.java, yang berfungsi sebagai test runner untuk masing-masing pengujian. Direktori src/test/resources/ berisi dua folder, yaitu featureWeb/ untuk menyimpan skenario pengujian website dan featureApi/ untuk skenario pengujian API. Selain itu, terdapat folder reports/ yang digunakan untuk menyimpan laporan hasil pengujian dalam format HTML dan JSON.

---------------------------------------------------------

Skenario Pengujian

1. Pengujian API

File fitur: Test Automation Rest Api

Pengujian: Ambil Daftar Pengguna

Siapkan URL yang valid untuk GET_LIST_USERS

Jalankan API untuk mengambil daftar pengguna

Validasi status kode 200

Validasi struktur respons

Validasi JSON sesuai dengan skema get_list_user_normal.json


Pengujian: Buat Pengguna Baru

Siapkan URL yang valid untuk CREATE_NEW_USERS

Jalankan API untuk membuat pengguna baru

Validasi status kode 200

Validasi isi respons

Validasi JSON sesuai dengan skema post_create_new_user_normal.json


Pengujian: Hapus Pengguna

Buat pengguna baru terlebih dahulu

Validasi status kode 200

Hapus pengguna yang baru dibuat

Validasi status kode 200


Pengujian: Perbarui Data Pengguna

Buat pengguna baru terlebih dahulu

Validasi status kode 200

Perbarui data pengguna

Validasi status kode 200

Validasi isi respons setelah diperbarui



2. Pengujian Website

File fitur: all feature

Login dan Navigasi ke Halaman Utama

Pengguna login dengan username: moblaze11 dan password: @Testing123

Pengguna berhasil masuk ke halaman utama

Interaksi Produk dan Pengelolaan Keranjang

Pengguna menambahkan beberapa produk ke dalam keranjang

Pengguna mengecek total harga di keranjang

Pengguna melakukan checkout dengan mengisi data dan menyelesaikan pembelian

Pengguna menghapus item dari keranjang

Pemutaran Video dan Pengiriman Pesan

Pengguna memutar dan menutup video

Pengguna mengirim pesan dan melihat pop-up konfirmasi

Logout

Pengguna logout dan kembali ke halaman login

---------------------------------------------------

Jalankan Pengujian API:
./gradlew dummyapi -Ptags="@api"   

Jalankan Pengujian Website:
./gradlew dummyapi -Ptags="@web"

Pengujian juga bisa dijalankan secara terpisah berdasarkan skenario dengan mengganti {tags} pada ./gradlew demoblaze -Ptags="{tags}"  sesuai dengan tag yang tersedia pada file feature, contoh:
./gradlew demoblaze -Ptags="@addToCart-OneItem" 

Output: Setelah menjalankan perintah ini, Gradle akan mengkompilasi proyek, menjalankan tes Cucumber, dan menghasilkan laporan dalam format HTML di direktori yang sudah ditentukan.
![image](https://github.com/user-attachments/assets/c2977f2c-60cf-44af-adf3-0e7a22968a78)


----------------------------------------------------

Laporan Pengujian

Setelah pengujian selesai, laporan akan tersedia di folder reports/ dalam format HTML dan JSON.

Proyek ini bertujuan untuk mengotomatiskan pengujian pada web dan API, sehingga meningkatkan keandalan serta stabilitas aplikasi yang diuji.


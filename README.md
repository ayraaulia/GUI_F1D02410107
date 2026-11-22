# Portofolio Saya — Aplikasi GUI Java Swing

| | |
|---|---|
| **Nama** | Ayra Aulia Saputri Hidayat |
| **NIM** | F1D02410107 |

---

## Fitur

- **Halaman utama**: ucapan selamat datang, daftar keahlian (Coding, Project Management, Writing), dan tombol *Contact Me*.
- **Halaman detail keahlian**: muncul saat salah satu kotak keahlian diklik, berisi deskripsi keahlian dan tombol *Back*.
- **Dialog kontak**: muncul saat tombol *Contact Me* diklik dan menampilkan nomor kontak.
- Warna dan font dikumpulkan dalam satu class `Theme` supaya konsisten.

## Struktur Proyek

```
.
├── Main.java                  # Window utama (JFrame) + pengatur perpindahan halaman
├── PortofolioPanel.java       # Halaman utama (JPanel)
├── DetailKeahlianPanel.java   # Halaman detail keahlian (JPanel)
├── Theme.java                 # Konstanta warna & font (public static)
└──  README.md
```
## 5 Komponen Utama GUI yang Digunakan

### 1. Top-level Container — `JFrame`

Top-level container adalah wadah paling luar yang menjadi jendela aplikasi. Di program ini, class `Main` **extends `JFrame`**.

```java
public class Main extends JFrame {
    public Main() {
        setTitle("Portofolio Saya");
        setSize(550, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        ...
    }
}
```

| Method | Fungsi |
|---|---|
| `setTitle()` | Mengatur judul jendela |
| `setSize()` | Mengatur ukuran jendela |
| `setDefaultCloseOperation()` | Menghentikan program saat jendela ditutup |
| `setLocationRelativeTo(null)` | Menampilkan jendela di tengah layar |
| `setVisible(true)` | Menampilkan jendela (dipanggil di `main`) |

### 2. Intermediate Container — `JPanel`

Intermediate container adalah wadah di dalam top-level container yang digunakan untuk mengelompokkan dan menata komponen lain.

| Class / Variabel | Peran |
|---|---|
| `PortofolioPanel` (**extends `JPanel`**) | Halaman utama |
| `DetailKeahlianPanel` (**extends `JPanel`**) | Halaman detail keahlian |
| `containerHalaman` (`JPanel`, di `Main`) | Wadah yang menampung kedua halaman di atas |
| `panelWelcome`, `panelKeahlian`, `panelRowKeahlian`, `panelContact` | Panel penyusun halaman utama |
| `panelJudul`, `panelDeskripsi`, `panelBack` | Panel penyusun halaman detail |

### 3. Atomic Component — `JLabel` dan `JButton`

Atomic component adalah komponen paling dasar yang tidak berfungsi sebagai wadah.

| Komponen | Variabel | Fungsi |
|---|---|---|
| `JLabel` | `labelWelcome` | Judul "Selamat Datang di Portofolio Saya" |
| `JLabel` | `labelSubjudul` | Subjudul "Daftar Keahlian" |
| `JLabel` | `labelJudul` | Judul halaman detail (mis. "Detail: Management") |
| `JLabel` | `labelDeskripsi` | Teks deskripsi keahlian (tag `<br>` dipakai untuk pindah baris) |
| `JButton` | `btnCoding`, `btnPM`, `btnWriting` | Kotak pilihan keahlian |
| `JButton` | `btnContact` | Membuka dialog kontak |
| `JButton` | `btnBack` | Kembali ke halaman utama |

Selain itu, `JOptionPane.showMessageDialog(...)` dipakai untuk menampilkan dialog nomor kontak.

### 4. Layout Classes — `CardLayout`, `BorderLayout`, `FlowLayout`

Program ini memakai **3 layout manager**:

| Layout | Dipakai di | Fungsi |
|---|---|---|
| `CardLayout` | `containerHalaman` (di `Main`) | Berpindah antar halaman (halaman utama ⇄ halaman detail) dalam satu jendela |
| `BorderLayout` | `PortofolioPanel`, `panelKeahlian`, `DetailKeahlianPanel`, dan `panelDeskripsi` | Membagi area menjadi atas (`NORTH`), tengah (`CENTER`), dan bawah (`SOUTH`) |
| `FlowLayout` | `panelWelcome`, `panelRowKeahlian`, `panelContact`, `panelJudul`, `panelBack` | Menata komponen secara berurutan dan rata tengah |

Contoh penggunaan `CardLayout`:

```java
cardLayout = new CardLayout();
containerHalaman = new JPanel(cardLayout);

containerHalaman.add(portofolioPanel, "portofolio");
containerHalaman.add(detailKeahlianPanel, "detail");

cardLayout.show(containerHalaman, "portofolio");   // tampilkan halaman utama
```

### 5. Event Listener — `ActionListener`

Event listener berfungsi menangani aksi pengguna. Program ini memakai interface **`ActionListener`** yang didaftarkan ke setiap `JButton` dengan `addActionListener(...)`.

| Tombol | Event yang terjadi |
|---|---|
| `btnCoding` | Membuka halaman detail "Coding" |
| `btnPM` | Membuka halaman detail "Management" |
| `btnWriting` | Membuka halaman detail "Writing" |
| `btnContact` | Menampilkan dialog nomor kontak |
| `btnBack` | Kembali ke halaman utama |

Setiap listener ditulis sebagai *anonymous class* yang meng-**override** method `actionPerformed(ActionEvent e)` milik interface `ActionListener`. Method inilah yang otomatis dipanggil Swing saat tombol diklik, sedangkan objek `ActionEvent e` membawa informasi tentang event tersebut.

```java
// PortofolioPanel.java
btnPM.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        mainApp.bukaDetailKeahlian(
                "Management",
                "Berpengalaman merencanakan sprint, membagi tugas tim, dan memantau"
                + "<br>progres proyek perangkat lunak.");
    }
});

btnContact.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        tampilkanDialogKontak();
    }
});
```

```java
// DetailKeahlianPanel.java
btnBack.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        mainApp.bukaPortofolio();
    }
});
```

Import yang dibutuhkan:

```java
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
```

---

| Class | Keterangan |
|---|---|
| `Main` | Extends `JFrame`. Membuat `containerHalaman`, `PortofolioPanel`, dan `DetailKeahlianPanel`, serta mengatur perpindahan halaman lewat `bukaDetailKeahlian()` dan `bukaPortofolio()` |
| `PortofolioPanel` | Extends `JPanel`. Menyimpan referensi `Main` (`mainApp`) agar bisa memanggil method perpindahan halaman |
| `DetailKeahlianPanel` | Extends `JPanel`. Menampilkan data keahlian lewat `setDataKeahlian(judul, deskripsi)` |
| `Theme` | Berisi atribut `public static` untuk warna (`BIRU`, `KUNING`, `PUTIH`, `HITAM`) dan font (`JUDUL`, `SUBJUDUL`, `NORMAL`, `TOMBOL`). Dipakai oleh kedua panel |

## Alur Program

1. `Main.main()` membuat objek `Main` lalu menampilkannya dengan `setVisible(true)`.
2. Halaman utama (`PortofolioPanel`) tampil pertama kali.
3. Klik salah satu kotak keahlian → `Main.bukaDetailKeahlian()` mengisi data lewat `setDataKeahlian()` lalu `CardLayout` menampilkan halaman detail.
4. Klik **Back** → `Main.bukaPortofolio()` menampilkan kembali halaman utama.
5. Klik **Contact Me** → dialog nomor kontak muncul.


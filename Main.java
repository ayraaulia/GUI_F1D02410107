import java.awt.CardLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Main extends JFrame {

    private CardLayout cardLayout;
    private JPanel containerHalaman;
    private PortofolioPanel portofolioPanel;
    private DetailKeahlianPanel detailKeahlianPanel;

    public Main() {
        // Pengaturan jendela
        setTitle("Portofolio Saya");
        setSize(550, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // jendela muncul di tengah layar

        cardLayout = new CardLayout();
        containerHalaman = new JPanel(cardLayout);

        // Membuat dua halaman
        portofolioPanel = new PortofolioPanel(this);
        detailKeahlianPanel = new DetailKeahlianPanel(this);

        // Memasukkan halaman ke container, setiap halaman diberi nama
        containerHalaman.add(portofolioPanel, "portofolio");
        containerHalaman.add(detailKeahlianPanel, "detail");

        add(containerHalaman);

        // Halaman pertama yang tampil adalah halaman portofolio
        cardLayout.show(containerHalaman, "portofolio");
    }

    // Pindah ke halaman detail dan isi datanya
    public void bukaDetailKeahlian(String judul, String deskripsi) {
        detailKeahlianPanel.setDataKeahlian(judul, deskripsi);
        cardLayout.show(containerHalaman, "detail");
    }

    // Kembali ke halaman portofolio
    public void bukaPortofolio() {
        cardLayout.show(containerHalaman, "portofolio");
    }

    public static void main(String[] args) {
        Main app = new Main();
        app.setVisible(true);
    }
}
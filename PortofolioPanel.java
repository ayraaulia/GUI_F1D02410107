import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class PortofolioPanel extends JPanel {

    private Main mainApp;

    private JPanel panelWelcome;
    private JPanel panelKeahlian;
    private JPanel panelRowKeahlian;
    private JPanel panelContact;

    private JLabel labelWelcome;
    private JLabel labelSubjudul;

    private JButton btnCoding;
    private JButton btnPM;
    private JButton btnWriting;
    private JButton btnContact;

    public PortofolioPanel(Main mainApp) {
        this.mainApp = mainApp;

        setLayout(new BorderLayout());
        setBackground(Theme.PUTIH);

        panelWelcome = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 20));
        panelWelcome.setBackground(Theme.PUTIH);

        labelWelcome = new JLabel("Selamat Datang di Portofolio Saya");
        labelWelcome.setFont(Theme.JUDUL);
        labelWelcome.setForeground(Theme.BIRU);
        panelWelcome.add(labelWelcome);

        panelKeahlian = new JPanel(new BorderLayout());
        panelKeahlian.setBackground(Theme.PUTIH);

        labelSubjudul = new JLabel("Daftar Keahlian", SwingConstants.CENTER);
        labelSubjudul.setFont(Theme.SUBJUDUL);
        labelSubjudul.setForeground(Theme.HITAM);

        panelRowKeahlian = new JPanel(new FlowLayout(FlowLayout.CENTER, 15, 10));
        panelRowKeahlian.setBackground(Theme.PUTIH);

        btnCoding = new JButton("Coding");
        btnPM = new JButton("Project Management");
        btnWriting = new JButton("Writing");

        JButton[] tombolKeahlian = { btnCoding, btnPM, btnWriting };
        for (JButton tombol : tombolKeahlian) {
            tombol.setFont(Theme.TOMBOL);
            tombol.setForeground(Theme.BIRU);
            tombol.setBackground(Theme.PUTIH);
            tombol.setBorder(BorderFactory.createLineBorder(Theme.BIRU, 3));
            tombol.setPreferredSize(new Dimension(160, 160));
            panelRowKeahlian.add(tombol);
        }

        panelKeahlian.add(labelSubjudul, BorderLayout.NORTH);
        panelKeahlian.add(panelRowKeahlian, BorderLayout.CENTER);

        panelContact = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 15));
        panelContact.setBackground(Theme.PUTIH);

        btnContact = new JButton("Contact Me");
        btnContact.setFont(Theme.TOMBOL);
        btnContact.setForeground(Theme.PUTIH);
        btnContact.setBackground(Theme.BIRU);
        btnContact.setPreferredSize(new Dimension(130, 35));
        panelContact.add(btnContact);

        add(panelWelcome, BorderLayout.NORTH);
        add(panelKeahlian, BorderLayout.CENTER);
        add(panelContact, BorderLayout.SOUTH);

        btnCoding.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainApp.bukaDetailKeahlian(
                        "Coding",
                        "Terbiasa membangun aplikasi desktop dan web menggunakan Java,"
                        + "<br>serta menerapkan prinsip pemrograman berorientasi objek.");
            }
        });

        btnPM.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainApp.bukaDetailKeahlian(
                        "Management",
                        "Berpengalaman merencanakan sprint, membagi tugas tim, dan memantau"
                        + "<br>progres proyek perangkat lunak.");
            }
        });

        btnWriting.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainApp.bukaDetailKeahlian(
                        "Writing",
                        "Mampu menulis dokumentasi teknis, laporan proyek, dan artikel"
                        + "<br>dengan bahasa yang jelas dan mudah dipahami.");
            }
        });

        btnContact.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tampilkanDialogKontak();
            }
        });
    }

    // Menampilkan kotak dialog berisi nomor kontak
    private void tampilkanDialogKontak() {
        JOptionPane.showMessageDialog(
                mainApp,
                "Nomor Kontak: +62 878-6565-2062",
                "Kontak",
                JOptionPane.PLAIN_MESSAGE);
    }
}
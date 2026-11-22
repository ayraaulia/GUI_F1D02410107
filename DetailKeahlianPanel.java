import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class DetailKeahlianPanel extends JPanel {

    private JPanel panelJudul;
    private JPanel panelDeskripsi;
    private JPanel panelBack;

    private JLabel labelJudul;
    private JLabel labelDeskripsi;

    private JButton btnBack;

    public DetailKeahlianPanel(Main mainApp) {

        setLayout(new BorderLayout());
        setBackground(Theme.PUTIH);

        panelJudul = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 30));
        panelJudul.setBackground(Theme.PUTIH);

        labelJudul = new JLabel("Detail");
        labelJudul.setFont(Theme.JUDUL);
        labelJudul.setForeground(Theme.BIRU);
        panelJudul.add(labelJudul);

        panelBack = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 25));
        panelBack.setBackground(Theme.PUTIH);

        btnBack = new JButton("Back");
        btnBack.setFont(Theme.TOMBOL);
        btnBack.setForeground(Theme.PUTIH);
        btnBack.setBackground(Theme.BIRU);
        btnBack.setPreferredSize(new Dimension(90, 35));
        panelBack.add(btnBack);

        labelDeskripsi = new JLabel("", SwingConstants.CENTER);
        labelDeskripsi.setFont(Theme.NORMAL);
        labelDeskripsi.setForeground(Theme.HITAM);

        panelDeskripsi = new JPanel(new BorderLayout());
        panelDeskripsi.setBackground(Theme.PUTIH);
        panelDeskripsi.add(labelDeskripsi, BorderLayout.NORTH);
        panelDeskripsi.add(panelBack, BorderLayout.CENTER);

        add(panelJudul, BorderLayout.NORTH);
        add(panelDeskripsi, BorderLayout.CENTER);

        btnBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainApp.bukaPortofolio();
            }
        });
    }

    // Mengisi judul dan deskripsi sesuai keahlian yang dipilih
    public void setDataKeahlian(String judul, String deskripsi) {
        labelJudul.setText("Detail: " + judul);

        labelDeskripsi.setText("<html><center>" + deskripsi + "</center></html>");
    }
}
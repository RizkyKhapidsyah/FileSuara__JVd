package com.rk;

import javax.sound.sampled.*;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class FileSuara extends JFrame {



    AudioInputStream suara;
    String eror1 = "Tidak Ada Eror";
    String eror2 = "Tidak Ada Eror";
    String eror3 = "Tidak Ada Eror";

    FileSuara() {
        try {
            suara = AudioSystem.getAudioInputStream(new File("ContohSuara.wav"));
            Clip klip = AudioSystem.getClip();
            klip.open(suara);
            klip.loop(0);
        } catch (UnsupportedAudioFileException e) {
            eror1 = e.toString();
        } catch (IOException e) {
            eror2 = e.toString();
        } catch (LineUnavailableException e) {
            eror3 = e.toString();
        }

        setTitle("Test File Suara");
        setSize(250, 200);
        setVisible(true);
        setDefaultCloseOperation(this.EXIT_ON_CLOSE);
    }

    public void paint(Graphics g) {
        g.drawString("Eror 1 : " + eror1, 10, 50);
        g.drawString("Eror 2 : " + eror1, 10, 100);
        g.drawString("Eror 3 : " + eror1, 10, 150);
    }

    public static void main(String[] args) {
        new FileSuara();
    }
}

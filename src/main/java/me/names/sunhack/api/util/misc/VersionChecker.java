package me.names.sunhack.api.util.misc;

import me.names.sunhack.client.SunHack;

import javax.swing.*;
import javax.swing.event.HyperlinkEvent;
import javax.swing.event.HyperlinkListener;
import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Scanner;

/**
 * @author 2b2t_names
 * @since 12/15/2020
 */

public class VersionChecker {

    public static void init() {
        checkVersion(SunHack.MODVER);
    }

    private static void checkVersion(String version) {
        boolean isLatest = true;
        String newVersion = "null";

        if (version.startsWith("d")) {
            return;
        }

        try {
            URL url = new URL("https://github.com/2b2tnames1/SunHack/blob/main/versioncontrol.txt");
            Scanner scanner = new Scanner(url.openStream());

            String grabbedVersion = scanner.next();

            if (!version.equalsIgnoreCase(grabbedVersion)) {
                isLatest = false;
                newVersion = grabbedVersion;
            }
        } catch (IOException e) {
            e.printStackTrace();
            isLatest = true;
        }

        if (!isLatest) {
            generatePopUp(newVersion);
        }
    }

    //thank god for stack overflow... https://stackoverflow.com/questions/8348063/clickable-links-in-joptionpane
    private static void generatePopUp(String newVersion) {
        JLabel label = new JLabel();
        Font font = label.getFont();

        String style = "font-family:" + font.getFamily() + ";" + "font-weight:" + (font.isBold() ? "bold" : "normal") + ";" + "font-size:" + font.getSize() + "pt;";
        JEditorPane editorPane = new JEditorPane("text/html", "<html><body style=\"" + style + "\">" + "Version outdated! Download the latest (" + newVersion + ") " + "<a href=\"https://github.com/IUDevman/gamesense-client/releases\">HERE</a>" + "!" + "</body></html>");

        editorPane.addHyperlinkListener(new HyperlinkListener() {

            @Override
            public void hyperlinkUpdate(HyperlinkEvent event) {

                if (event.getEventType().equals(HyperlinkEvent.EventType.ACTIVATED)) {

                    try {
                        Desktop.getDesktop().browse(event.getURL().toURI());
                    } catch (IOException e) {
                        e.printStackTrace();
                    } catch (URISyntaxException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        editorPane.setEditable(false);
        editorPane.setBackground(label.getBackground());
        JOptionPane.showMessageDialog(null, editorPane, SunHack.MODNAME + " " + SunHack.MODVER, JOptionPane.WARNING_MESSAGE);
    }
}
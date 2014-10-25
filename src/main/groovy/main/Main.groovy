package main

import download.Downloader

/**
 * Created by misterti.me on 5/26/2014.
 *
 * Ported to Groovy by Kepler Sticka-Jones on 10/24/2014.
 */
class Main {
    static void main(String[] args) throws Exception {
        File f = new File("C:\\Users\\misterti.me\\Desktop\\XML\\mods.xml")
        File g = new File("C:\\Users\\misterti.me\\Desktop\\XML\\IC2-2.1.477.jar")

        Downloader.installResources()
        //XMLParser.parseMods(f)
    }
}

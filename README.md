Rebel Launcher
==============

The Rebel Launcher is a fully extensible Minecraft Launcher, using \*gasp\* XML as its markup.

How It Works
============

Coming soon.

XML Format
==========
The XML format and parsing facilities are not finished yet, however, this is what we have so far:
packInfo.xml
        <packInfo>
			<!-- Name of the pack -->
			<packName>Meep the Beast</packName>

			<!-- Version of the pack -->
			<packVersion>1.2.3.4</packVersion>

			<!-- Minecraft version the pack is for -->
			<MCVersion>1.6.4</MCVersion>

			<!-- Branch of the pack (unstable, alpha, beta, release) -->
			<branch>Unstable</branch>
		</packInfo>
mods.xml
	<mods>
		<!-- To include a mod from the official repository:  -->
		<mod xml="http://rebelclients.com/edmond/mods/IndustrialCraft2/IC2-2.1.477.xml"/>

		<!-- To install a mod from somewhere else:  -->
		<mod url="http://some-mod-download-site.com/mods/Hats.zip" permissions="[link to screenshot of permissions]"/>
	</mods>
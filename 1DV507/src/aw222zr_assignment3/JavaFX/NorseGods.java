package aw222zr_assignment3.JavaFX;

import java.util.ArrayList;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * Class for displaying a window with information about various Norse gods.
 * @author Anton Wiklund
 *
 */
public class NorseGods extends Application {

	public static void main(String[] args) {
		launch(args);
	}

	
	public void start(Stage primaryStage) throws Exception {

		Label mainLabel = new Label("Norse Gods, and other Beings:");
		mainLabel.setFont(Font.font(null ,FontWeight.BOLD, 24));
		
		// List of gods:
		ListView<String> norseList = new ListView<>();
		norseList.getItems().addAll(
				"Thor",
				"Loki",
				"Odin",
				"Baldr",
				"Freyr",
				"Freyja",
				"Heimdallr",
				"Bragi",
				"Tyr"
				);
		norseList.setMinWidth(98);
		norseList.setMaxWidth(98);
		norseList.setMinHeight(310);
		norseList.setMaxHeight(310);
		
		// Main area for text:
		GridPane godGrid = new GridPane();
		// God name:
		Label godNa = new Label(godName); godGrid.add(godNa, 0, 0);	
		godNa.setFont(Font.font("verdana", FontWeight.BLACK, FontPosture.ITALIC, 16));
		// God description:
		TextArea godDe = new TextArea(godDescription); godGrid.add(godDe, 0, 2);	
		godDe.setWrapText(true);	
		godDe.setPadding(new Insets(2,2,2,2)); 
		godDe.setFont(Font.font("verdana", 11));
		godDe.setMinHeight(265);
		// God race:
		Text godRa = new Text(godRace);	godGrid.add(godRa, 0, 1);
		godRa.setFont(Font.font("verdana", FontPosture.ITALIC, 12));
		// God grid:
		godGrid.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID,
				CornerRadii.EMPTY, BorderWidths.FULL)));
		godGrid.setHgap(5);
		godGrid.setVgap(5);
		godGrid.setPadding(new Insets(5,5,5,5));
		GridPane.setMargin(godGrid, new Insets(5,5,5,10));
		godGrid.setMinHeight(310);
		godGrid.setMinWidth(280);
		ScrollPane godScroll = new ScrollPane();
		godScroll.setContent(godGrid);
		
		// Add all elements to the main grid:
		GridPane mainGrid = new GridPane();
		mainGrid.add(norseList, 0, 1);
		mainGrid.add(mainLabel, 0, 0, 2, 1);
		mainGrid.add(godGrid, 1, 1);
		mainGrid.setPadding(new Insets(10,10,10,10));
		
		// EventListeners:
		norseList.getSelectionModel().selectedIndexProperty().addListener(e -> {
			setName(getName(norseList.getSelectionModel().getSelectedIndex()));
			godNa.setText(godName);
		
			setDescription(getDescription(norseList.getSelectionModel().getSelectedIndex()));
			godDe.setText(godDescription);
			
			setRace(getRace(norseList.getSelectionModel().getSelectedIndex()));
			godRa.setText(godRace);
		});
		
		// Setup scene:
		Scene scene = new Scene(mainGrid, 510, 410);
		
		// Setup primaryStage:
		primaryStage.setTitle("Norse Gods, and other Beings");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	/**
	 * ArrayList with the various information for the gods.
	 * @return
	 */
	private ArrayList<Object> getArrayList() {
	ArrayList<Object> godArray = new ArrayList<Object>();
	// READ: I found it very hard to find the correct races of various gods. I decided to replace them with the gods main characteristics.
	// Create array for each of the gods, with the respective gods information:
	String[] thor = 		{"Thor", "God of War", thorString};
	String[] loki = 		{"Loki", "God of Wisdom", lokiString};
	String[] odin = 		{"Odin", "God of Gods", odinString};
	String[] baldr = 		{"Baldr", "God of Joy", baldrString};
	String[] freyr = 		{"Freyr", "God of Virility", freyrString};
	String[] freyja = 		{"Freyja", "God of Love", freyjaString};
	String[] heimdallr =	{"Heimdallr", "God of Song", heimdallrString};
	String[] bragi = 		{"Bragi", "God of Poetry", bragiString};
	String[] tyr = 			{"Tyr", "God of War", tyrString};
	
	godArray.add(thor);	godArray.add(loki);	godArray.add(odin);	godArray.add(baldr); godArray.add(freyr);
	godArray.add(freyja); godArray.add(heimdallr); godArray.add(bragi); godArray.add(tyr);	
	
	return godArray;
	}
	
	String godDescription = "";
	String godRace = "";
	String godName = "";
	
	/**
	 * Get god name.
	 * @param name
	 * @return
	 */
	private String getName(int name) {
		String nameString = null;
		// Find correct value from ArrayList:
		ArrayList<Object> checkList = getArrayList();
		String[] testi = (String[]) checkList.get(name);
		nameString = testi[0];
		return nameString;
	}
	
	/**
	 * Set god name.
	 * @param nameString
	 */
	private void setName(String nameString) {
		godName = nameString;
	}
	
	/**
	 * Get god race.
	 * @param string
	 * @return
	 */
	private String getRace(int string) {
		String raceString = "";
		// Find correct value from ArrayList:
		ArrayList<Object> checkList = getArrayList();
		String[] testi = (String[]) checkList.get(string);
		raceString = testi[1];
		return raceString;
	}
	
	/**
	 * Set god race.
	 * @param string
	 */
	private void setRace(String string) {
		godRace = string;
	}
	
	/**
	 * Get god description.
	 * @param desc
	 * @return
	 */
	private String getDescription(int desc) {
		String descString = "";
		// Find correct value from ArrayList:
		ArrayList<Object> checkList = getArrayList();
		String[] testi = (String[]) checkList.get(desc);
		descString = testi[2];
		return descString;
	}
	
	/**
	 * Set god description.
	 * @param desc
	 */
	private void setDescription(String desc) {
		godDescription = desc;
	}
	
	private String odinString = "In Germanic mythology, Odin (from Old Norse Óðinn) is a widely revered god. In Norse mythology, from which stems most of the information about the god, Odin is associated with wisdom, healing, death, royalty, the gallows, knowledge, battle, sorcery, poetry, frenzy, and the runic alphabet, and is the husband of the goddess Frigg. In wider Germanic mythology and paganism, Odin was known in Old English as Wōden, in Old Saxon as Wōdan, and in Old High German as Wuotan or Wōtan, all stemming from the reconstructed Proto-Germanic theonym *wōđanaz.\r\n" + 
			"\r\n" + 
			"Odin is a prominently mentioned god throughout the recorded history of the Germanic peoples, from the Roman occupation of regions of Germania through the tribal expansions of the Migration Period and the Viking Age. In the modern period, Odin continued to be acknowledged in the rural folklore of Germanic Europe. References to Odin appear in place names throughout regions historically inhabited by the ancient Germanic peoples, and the day of the week Wednesday bears his name in many Germanic languages, including English.\r\n" + 
			"\r\n" + 
			"In Old English texts, Odin holds a particular place as a euhemerized ancestral figure among royalty, and he is frequently referred to as a founding figure among various other Germanic peoples, including the Langobards. Forms of his name appear frequently throughout the Germanic record, though narratives regarding Odin are mainly found in Old Norse works recorded in Iceland, primarily around the 13th century. These texts make up the bulk of modern understanding of Norse mythology.\r\n" + 
			"\r\n" + 
			"In Old Norse texts, Odin is depicted as one-eyed and long-bearded, frequently wielding a spear named Gungnir, and wearing a cloak and a broad hat. He is often accompanied by his animal companions and familiars—the wolves Geri and Freki and the ravens Huginn and Muninn, who bring him information from all over Midgard—and rides the flying, eight-legged steed Sleipnir across the sky and into the underworld. Odin is attested as having many sons, most famously the gods Thor (with Jörð) and Baldr (with Frigg), and is known by hundreds of names. In these texts, he frequently seeks greater knowledge, at times in disguise (most famously by obtaining the Mead of Poetry), makes wagers with his wife Frigg over the outcome of exploits, and takes part in both the creation of the world by way of slaying the primordial being Ymir and the gift of life to the first two humans Ask and Embla. Odin has a particular association with Yule, and mankind's knowledge of both the runes and poetry is also attributed to him, giving Odin aspects of the culture hero.";
	
	private String freyrString = "Freyr (Old Norse: Lord), sometimes anglicized as Frey, is a widely attested god associated with sacral kingship, virility and prosperity, with sunshine and fair weather, and pictured as a phallic fertility god in Norse mythology. Freyr is said to \"bestow peace and pleasure on mortals.\" Freyr, sometimes referred to as Yngvi-Freyr, was especially associated with Sweden and seen as an ancestor of the Swedish royal house.\r\n" + 
			"\r\n" + 
			"In the Icelandic books the Poetic Edda and the Prose Edda, Freyr is presented as one of the Vanir, the son of the sea god Njörðr, as well as the twin brother of the goddess Freyja. The gods gave him Álfheimr, the realm of the Elves, as a teething present. He rides the shining dwarf-made boar Gullinbursti and possesses the ship Skíðblaðnir which always has a favorable breeze and can be folded together and carried in a pouch when it is not being used. He has the servants Skírnir, Byggvir and Beyla.\r\n" + 
			"\r\n" + 
			"The most extensive surviving Freyr myth relates Freyr's falling in love with the female jötunn Gerðr. Eventually, she becomes his wife but first Freyr has to give away his magic sword which fights on its own \"if wise be he who wields it.\" Although deprived of this weapon, Freyr defeats the jötunn Beli with an antler. However, lacking his sword, Freyr will be killed by the fire jötunn Surtr during the events of Ragnarök.\r\n" + 
			"\r\n" + 
			"Like other Germanic deities, veneration of Freyr is revived in the modern period in Heathenry movement.";
	
	private String freyjaString = "In Norse mythology, Freyja (/ˈfreɪə/; Old Norse for \"(the) Lady\") is a goddess associated with love, sex, beauty, fertility, gold, seiðr, war, and death. Freyja is the owner of the necklace Brísingamen, rides a chariot pulled by two cats, accompanied by the boar Hildisvíni, and possesses a cloak of falcon feathers. By her husband Óðr, she is the mother of two daughters, Hnoss and Gersemi. Along with her twin brother Freyr, her father Njörðr, and her mother (Njörðr's sister, unnamed in sources), she is a member of the Vanir. Stemming from Old Norse Freyja, modern forms of the name include Freya, Freyia, and Freja.\r\n" + 
			"\r\n" + 
			"Freyja rules over her heavenly field Fólkvangr and there receives half of those that die in battle, whereas the other half go to the god Odin's hall, Valhalla. Within Fólkvangr lies her hall, Sessrúmnir. Freyja assists other deities by allowing them to use her feathered cloak, is invoked in matters of fertility and love, and is frequently sought after by powerful jötnar who wish to make her their wife. Freyja's husband, the god Óðr, is frequently absent. She cries tears of red gold for him, and searches for him under assumed names. Freyja has numerous names, including Gefn, Hörn, Mardöll, Sýr, Valfreyja, and Vanadís.";
	
	private String baldrString = "Baldr (also Balder, Baldur) is a Æsir god of light, joy, purity, and the summer sun in Norse mythology, and a son of the god Odin and the goddess Frigg. He is the father of Forseti, and He has numerous brothers, such as Thor and Váli.\r\n" + 
			"\r\n" + 
			"In the 12th century, Danish accounts by Saxo Grammaticus and other Danish Latin chroniclers recorded a euhemerized account of his story. Compiled in Iceland in the 13th century, but based on much older Old Norse poetry, the Poetic Edda and the Prose Edda contain numerous references to the death of Baldr as both a great tragedy to the Æsir and a harbinger of Ragnarök. In addition to being loved by all gods and more physical beings, he was so handsome, generous, and good that he gave off light simply by the purity of his character.\r\n" + 
			"\r\n" + 
			"According to Gylfaginning, a book of Snorri Sturluson's Prose Edda, Baldr's wife is Nanna and their son is Forseti. In Gylfaginning, Snorri relates that Baldr had the greatest ship ever built, Hringhorni, and that there is no place more beautiful than his hall, Breidablik.";
	
	private String heimdallrString = "In Norse mythology, Heimdallr is a god who possesses the resounding horn Gjallarhorn, owns the golden-maned horse Gulltoppr, has gold teeth, and is the son of Nine Mothers, grandson of Aegir and great grandson of Fornjotr. Heimdallr is attested as possessing foreknowledge, keen eyesight and hearing, and keeps watch for the onset of Ragnarök while drinking fine mead in his dwelling Himinbjörg, located where the burning rainbow bridge Bifröst meets heaven. Heimdallr is said to be the originator of social classes among humanity and once regained Freyja's treasured possession Brísingamen while doing battle in the shape of a seal with Loki. Heimdallr and Loki are foretold to kill one another during the events of Ragnarök. Heimdallr is additionally referred to as Rig, Hallinskiði, Gullintanni, and Vindlér or Vindhlér.\r\n" + 
			"\r\n" + 
			"Heimdallr is attested in the Poetic Edda, compiled in the 13th century from earlier traditional material; in the Prose Edda and Heimskringla, both written in the 13th century by Snorri Sturluson; in the poetry of skalds; and on an Old Norse runic inscription found in England. Two lines of an otherwise lost poem about the god, Heimdalargaldr, survive. Due to the problematic and enigmatic nature of these attestations, scholars have produced various theories about the nature of the god, including his apparent relation to rams, that he may be a personification of or connected to the world tree Yggdrasil, and potential Indo-European cognates.";
	
	private String tyrString = "Týr (/tɪər/;[1] Old Norse: Týr [tyːr]) is a Germanic god associated with law and heroic glory in Norse mythology, portrayed as one-handed. Corresponding names in other Germanic languages are Gothic Teiws, Old English Tīw and Old High German Ziu and Cyo, all from Proto-Germanic *Tīwaz. The Latinised name is rendered as Tius or Tio and also formally as Mars Thincsus.[2]\r\n" + 
			"\r\n" + 
			"In the late Icelandic Eddas, Týr is portrayed, alternately, as the son of Odin (Prose Edda) or of Hymir (Poetic Edda), while the origins of his name and his possible relationship to Tuisto (see Tacitus' Germania) suggest he was once considered the father of the gods and head of the pantheon, since his name is ultimately cognate to that of *Dyeus (cf. Dyaus), the reconstructed chief deity in Indo-European religion. It is assumed that Tîwaz was overtaken in popularity and in authority by both Odin and Thor at some point during the Migration Age, as Odin shares his role as God of war.\r\n" + 
			"\r\n" + 
			"Tiw was equated with Mars in the interpretatio germanica. Tuesday is \"Tīw's Day\" (also in Alemannic Zischtig from zîes tag), translating dies Martis.";
	
	private String bragiString = "Snorri Sturluson writes in the Gylfaginning after describing Odin, Thor, and Baldr:\r\n" + 
			"\r\n" + 
			"One is called Bragi: he is renowned for wisdom, and most of all for fluency of speech and skill with words. He knows most of skaldship, and after him skaldship is called bragr, and from his name that one is called bragr-man or -woman, who possesses eloquence surpassing others, of women or of men. His wife is Iðunn.\r\n" + 
			"\r\n" + 
			"In Skáldskaparmál Snorri writes:\r\n" + 
			"\r\n" + 
			"How should one periphrase Bragi? By calling him husband of Iðunn, first maker of poetry, and the long-bearded god (after his name, a man who has a great beard is called Beard-Bragi), and son of Odin.\r\n" + 
			"\r\n" + 
			"That Bragi is Odin's son is clearly mentioned only here and in some versions of a list of the sons of Odin (see Sons of Odin). But \"wish-son\" in stanza 16 of the Lokasenna could mean \"Odin's son\" and is translated by Hollander as Odin's kin. Bragi's mother is possibly the giantess Gunnlod. If Bragi's mother is Frigg, then Frigg is somewhat dismissive of Bragi in the Lokasenna in stanza 27 when Frigg complains that if she had a son in Ægir's hall as brave as Baldr then Loki would have to fight for his life.\r\n" + 
			"\r\n" + 
			"In that poem Bragi at first forbids Loki to enter the hall but is overruled by Odin. Loki then gives a greeting to all gods and goddesses who are in the hall save to Bragi. Bragi generously offers his sword, horse, and an arm ring as peace gift but Loki only responds by accusing Bragi of cowardice, of being the most afraid to fight of any of the Æsir and Elves within the hall. Bragi responds that if they were outside the hall, he would have Loki's head, but Loki only repeats the accusation. When Bragi's wife Iðunn attempts to calm Bragi, Loki accuses her of embracing her brother's slayer, a reference to matters that have not survived. It may be that Bragi had slain Iðunn's brother.";
	
	private String lokiString = "Loki (Old Norse [loki]) is a god in Norse mythology. Loki is in some sources the son of Fárbauti and Laufey, and the brother of Helblindi and Býleistr. By the jötunn Angrboða, Loki is the father of Hel, the wolf Fenrir, and the world serpent Jörmungandr. By his wife Sigyn, Loki is the father of Narfi and/or Nari. By the stallion Svaðilfari, Loki is the mother—giving birth in the form of a mare—to the eight-legged horse Sleipnir. In addition, Loki is referred to as the father of Váli in Prose Edda, though this source also refers to Odin as the father of Váli twice, and Váli is found mentioned as a Son of Loki only once.\r\n" + 
			"\r\n" + 
			"Loki's relation with the gods varies by source; Loki sometimes assists the gods and sometimes behaves in a malicious manner towards them. Loki is a shape shifter and in separate incidents he appears in the form of a salmon, a mare, a fly, and possibly an elderly woman named Þökk (Old Norse 'thanks'). Loki's positive relations with the gods end with his role in engineering the death of the god Baldr and Loki is eventually bound by Váli with the entrails of one of his sons. In both the Poetic Edda and the Prose Edda, the goddess Skadi is responsible for placing a serpent above him while he is bound. The serpent drips venom from above him that Sigyn collects into a bowl; however, she must empty the bowl when it is full, and the venom that drips in the meantime causes Loki to writhe in pain, thereby causing earthquakes. With the onset of Ragnarök, Loki is foretold to slip free from his bonds and to fight against the gods among the forces of the jötnar, at which time he will encounter the god Heimdallr and the two will slay each other.";
	
	private String thorString = "In Norse mythology, Thor (from Old Norse Þórr) is the hammer-wielding Æsir god of thunder and lightning, associated with storms, oak trees, strength, hallowing, fertility, the protection of mankind and of the fortress of Asgard. The son of Odin All-Father and Jörð (the personification of Earth), he is physically the strongest of the Æsir. The cognate deity in wider Germanic mythology and paganism was known in Old English as Þunor (Thunor) and in Old High German as Donar, stemming from a Proto-Germanic *Þunraz, meaning \"thunder\".\r\n" + 
			"\r\n" + 
			"Thor is a prominently mentioned god throughout the recorded history of the Germanic peoples, from the Roman occupation of regions of Germania, to the tribal expansions of the Migration Period, to his high popularity during the Viking Age, when, in the face of the process of the Christianization of Scandinavia, emblems of his hammer, Mjölnir, were worn and Norse pagan personal names containing the name of the god bear witness to his popularity.";
	
}

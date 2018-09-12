# Webviz
Diese Anwendung dient als Showcase, um Graphen in _dot_ Notation zur Laufzeit mittels [viz.js](https://github.com/mdaines/viz.js/) zu rendern.

## Quickstart
Da es sich hierbei um ein Spring Boot Projekt handelt, genügt es die Jar zu bauen und dann auszuführen.

 ./gradlew jar
 
Und dann.
 
 java -jar libs/webviz-x.x.x-SNAPSHOT.jar
 
## dot? Graphviz?
Viele Datenstrukturen lassen sich als Graphen beschreiben.
Eine Beschreibungssprache für Graphen lautet _dot_ und die dazugehörige Software-Suite nennt sich Graphviz.
Für eine Einführung in _dot_ verweise ich auf meinen [Vortrag](https://drosowski.github.io/dotlang).

## Was kann Webviz?

### Sketch'a'dot
Hier kannst du ein bisschen mit der _dot_ Sprache rumspielen.
Deine Eingabe wird direkt mit viz.js gerendert, ohne Umwege auf den Server.

### Java Datenstrukturen
Hier kannst du Datenstrukturen in Java visualisieren.
Wenn du schon immer mal wissen wolltest, wie genau sich eigentlich eine LinkedList von einer ArrayList unterscheidet, oder wo der Unterschied zwischen einer HashMap und einer TreeMap ist, bist du hier richtig.
Mit Hilfe von Beanshell, wird der Quelltext der im Textfeld eingegeben wird evaluiert und hinterher mit dem [Lightweight-Java-Visualizer](https://www.cs.auckland.ac.nz/~j-hamer/LJV.html) als Graph mit _dot_ dargestellt.
Das Ergebnis wird dann an den Browser geschickt und mit viz.js gerendert.

### Netzwerk
Von den [Datasets](https://github.com/gephi/gephi/wiki/Datasets) von Gephi ausgeborgt, stellen wir das Netzwerk der Charaktere von "Les Misérables" dar.
Jeder Charakter ist ein Knoten und jede Interaktion mit einem anderen Charakter wird als gewichtete Kante dargestellt.
Umso dicker die Kante, desto mehr Interaktion fanden zwischen den Charakteren statt.
Die Protagonisten (die Charaktere mit mehr als 5 Interaktionen) werden mit einem hellblau hinterlegt.

### Entscheidungsbaum
In diesem Beispiel betrachten wir einen Entscheidungsbaum, wie er für ein Expertensystem im Steuerumfeld aussehen könnte.
Der Baum besteht aus vier verschiedenen Knoten:

* Entscheidungsknoten
* Fehlerknoten
* Verweise auf Teilbäume
* Ergebnisknoten

Die Entscheidungsknoten beinhalten immer eine Frage die mit Ja (grün) oder Nein (rot) beantwortet werden kann.
Je nach Antwort, wird der entsprechende Zweig im Baum genommen.

Die Fehlerknoten weisen auf einen ungültigen Pfad im Baum hin.
Das kann z.B. im Fehlerfall vorkommen, oder wenn der Fall von dem Entscheidungsbaum noch nicht unterstützt wird.

Hinter den Verweisen auf Teilbäume, verbergen sich kleinere Entscheidungsbäume die von verschiedenen Knoten referenziert werden können.
Die Verweise können angeklickt werden und dann landet man in dem entsprechenden Teilbaum.

Die Blätter in dem Entscheidungsbaum sind dann die Ergebnisknoten.
Ein Ergebnisknoten beinhaltet dann eine Handlungsempfehlung, wie mit dem konkreten Steuerfall umgegangen werden sollte. 
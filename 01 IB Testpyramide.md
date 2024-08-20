# Die Testpyramide

Die Testpyramide von Mike Cohn plädiert für viele schnelle Unit-Tests bei der Entwicklung von Anwendungen. Komplexere und langsamere Integrations- und Systemtests sollen hingegen einen deutlich geringeren Anteil ausmachen. Welche Vorteile hat dieses Konzept?

![](./Titelfoto_Testpyramide.jpg)

Automatisierte Tests sind aus der Software-Entwicklung nicht mehr wegzudenken und ihre Einsatzmöglichkeiten sind vielfältig. Doch wann sollte welche Art von Test (Unit, Integration, System, ...) eingesetzt werden? Es braucht eine Teststrategie, um die Vorteile der verschiedenen Varianten auszuschöpfen. Die von Mike Cohn entwickelte Testpyramide liefert eine Strategie zum Testen von Anwendungen.
## Arten von Softwaretests 

Vor einem näheren Blick auf die Testpyramide werden zunächst die verschiedenen Testarten kurz vorgestellt. Zur besseren Einordnung werden die Tests anhand der verwendeten Testmethode und des Test-Levels bewertet. Mit Testmethode ist der Box-Ansatz gemeint (White-Box, Gray-Box, Black-Box), welcher den Blickwinkel beschreibt, der bei der Testentwicklung eingenommen wurde. Während beim White-Box-Test die Codestruktur bekannt ist, wird beim Black-Box-Test eine Außenperspektive eingenommen. Die Test-Level gehen hingegen auf den SWEBOK Guide der IEEE zurück und beziehen sich auf den Umfang des geprüften Codes in Unit-, Integration- und System-Tests.
Tests können in JUnit 5 mit verschiedenen Assertions formuliert werden. 

### Unit-Tests

Mit Unit-Tests wird das Verhalten einzelner Komponenten – wie Klassen, Funktionen oder Methoden – überprüft, unter Berücksichtigung der inneren Funktionalität (White-Box-Test). Sie sind einfach zu erstellen und können sehr schnell durchgeführt werden. Ihre Ausführungszeiten liegen meist bei wenigen Millisekunden, selbst umfangreichere Tests dauern nicht länger als 1-2 Minuten.

### Integrationstests

Integrationstests prüfen die Schnittstelle und das Zusammenspiel zwischen zwei Komponenten. Sie behandeln die zu testende Anwendung in der Regel als Black-Box (Black-Box-Test). Gelegentlich wird auch ein Gray-Box-Test eingesetzt, wenn neben dem Verhalten von Schnittstellen auch interne Abläufe überprüft werden sollen. Die Tests werden so realitätsnah wie möglich in einer produktionsähnlichen Laufzeitumgebung ausgeführt, was die Ausführungszeit deutlich erhöht.

### Systemtests

Der Fokus von Systemtests liegt auf dem Verhalten des gesamten Systems. Systemtests können daher als Oberbegriff für UI-Tests und End-to-End-Tests (E2E-Tests) verstanden werden. Da bei diesen Tests ausschließlich das externe Verhalten der Anwendung überprüft wird, handelt es sich um Black-Box-Tests.

## Die Testpyramide von Mike Cohn

Die Testpyramide von Mike Cohn beschreibt ein Konzept zum Einsatz der genannten automatisierten Softwaretests. Die Pyramide besteht aus drei Leveln, aufgebaut nach Einsatzhäufigkeit und Relevanz. Sie ordnet also nicht nur ein, sondern bewertet Unit-Tests, Integrationstests und Systemtests auch. 

![](./Die_Testpyramide_von_Mike_Cohn.jpg)

Die breite Basis der Testpyramide bilden im Idealfall viele schnelle und einfach zu wartende Unit-Tests. So können die meisten Fehler schon in frühen Phasen der Entwicklung entdeckt werden. Auf dem mittleren Level befinden sich die Integrationstests. Sie leisten wertvolle Dienste bei der zielgerichteten Prüfung von kritischen Schnittstellen. Die Ausführungszeiten von Integrationstests sind länger und auch ihre Pflege ist aufwändiger als die von Unit-Tests.

Die Spitze der Pyramide besteht aus langsamen Systemtests, die mitunter sehr wartungsintensiv sind. Systemtests sind sehr hilfreich, um die Funktion der Anwendung als Ganzes zu prüfen. Zum Testen von Verzweigungen im Code sind sie jedoch ungeeignet. Da die Tests des oberen Levels zeitintensiv und somit teuer sind, muss der Einsatz von aufwendigen Systemtests sorgfältig abgewogen werden. Grundsätzlich sollten so viele Tests wie möglich auf den untersten Level (Unit-Tests) verlagert werden. Tritt bei Integrations- oder Systemtests ein Fehler auf, muss dieser nicht nur behoben, sondern auch ein entsprechender Unit-Test geschrieben werden, um ein erneutes Auftreten zu verhindern.

Der Text ist der erste Teil des Artikels "Die Testpyramide" von Marie Poenisch, https://www.openknowledge.de/blog/die-testpyramide
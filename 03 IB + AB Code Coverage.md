# Code Coverage

Code Coverage dient vielen Entwicklern als wichtigste Metrik für die Vollständigkeit von Softwaretests. Code Coverage wird meist mit 
**Abdeckungsgrad**, **Testabdeckung** oder **Code-Abdeckung** übersetzt. Diese Maßzahl gibt den Anteil der tatsächlich durchgeführten 
Tests zu den theoretisch möglichen Tests an. Die Code Coverage beantwortet die Frage: Wie viel Prozent des Quellcodes sind durch 
Testfälle überdeckt? Dabei unterscheidet man verschiedene Abdeckungsgrade, die am folgenden Codebeispiel, der Ermittlung des größten, 
gemeinsamen Teilers zweier Zahlen, erläutert werden sollen:

```sh 
1   public int ggt(int number1, int number2){ 
2      int temp; 
3      if(number2>number1){ 
4         temp = number1;
5         number1 = number2;
6         number2 = temp;  
7      } 
8      temp = number1 % number2;
9      while(temp != 0){
10        number1 = number2;
11        number2 = temp;
12        temp = number1 % number2;
13     } 
14     return number2; 
15  } 
```

### Anweisungsüberdeckung (Statement Coverage)
Die Anweisungsüberdeckung fordert, dass jede Anweisung des Quellcodes mindestens einmal ausgeführt wird. In unserem Bespiel heißt das,
dass jede einfache Anweisung, if-Anweisung und die Schleife ausgeführt werden müssen. Dabei spielt es keine Rolle, dass bestimmte Kanten,
wie das Überspringen der Verzweigung und der Schleife bei unwahren boolschen Bedingungen, nicht berücksichtigt werden. Im obigen Beispiel
reicht ein Testfall aus, der ggt mit number1 = 20 und number2 = 45 (im Folgenden ggt(20, 45)) aufruft, um eine 100%ige Anweisungsüberdeckung zu 
erreichen. 

Die Anweisungsüberdeckung ist ein schwaches Testverfahren, mit dem nur ca. 18% der Fehler gefunden werden. In jedem Fall wird Code identifiziert ,
der niemals ausgeführt wird, wie zum Beispiel den Code einer Verzweigung, der niemals ausgeführt wird, weil die die dafür nötige Bedingung
niemals eintritt. Als einziges Testverfahren ist sie also nicht hinreichend, in Kombination mit anderen Testverfahren aber durchaus nützlich. 

### Zweigabdeckung (Branch Coverage)
Bei vollständiger **Zweigabdeckung**  wird jeder Zweig einer Anwendung mindestens einmal durlaufen: z.B. einmal if und einmal else oder einmal
while und einmal nicht while. In unserem Beispiele reichen dazu zwei Testfälle: ggt(20, 45) sorgt dafür, dass der Zweig der true-Zweig der If-Anweisung 
sowie der Schleifenkörper ausgeführt werden. ggt(30, 10) führt dazu, dass sowohl die Bedingung der If-Anweisung (10 ist nicht größer als 30) sowie
die Schleifenbedingung nicht erfüllt ist (30 % 10 ist 0, so dass temp nicht ungleich 0 ist), so dass in beiden Fällen der Kontrollfluß
abgewiesen wird. 

Die Zweigabdeckung ist wesentlich stärker als die Anweisungsüberdeckung - kein Wunder, eine 100%ige Zweigaabdeckung ist automatisch eine 100%ige
Anweisungsüberdeckung. Sie hat mit ca. 34% eine höhere Fehleridentifzierungsquote. So werden 79% der Kontrollflußfehler (falsche Bedingungensformulierungen)
und 20% der Berechnungsfehler gefunden. Sie gilt als das minimale Kriterium für Testverfahren. Auch mit diesem Kriterium werden nicht ausführbare
Verzweigungen gefunden. 
Die Zweigabdeckung berücksichtigt allerdings keine Abhängigkeiten zwischen Zweigen und ist unzureichend für das Testen von Schleifen. Außerdem 
ist sie nicht geeignet, komplexe Bedingungen wie if(a<10 || y>20) zu testen, da sie nur überprüft, ob beide Zweige durchlaufen werden, nicht aber die 
verschiedenen Kombinationen der einzelnen boolschen Ausdrücke. 

### Pfadabdeckung (Path Coverage)
Die ersten beiden Nachteile der Zweigabdeckung führen zur **Pfadabdeckung**. Sie ist das mächtigste kontrollflußorientierte Testverfahren. Bei 
100%iger Pfadabdeckung wird jeder mögliche Pfad durch die Anwendung mindestens einmal durchlaufen - Das klingt gut! Sobald Schleifen getestet werden,
ist die Pfadabdeckung aber selten praktizierbar. Die Pfadanzahl bei unbestimmten Wiederholungen (while, ...) ist nicht beschränkt, man denke an den
einfachen Fall `while(true){...}`, so dass es entweder eine sehr große Anzahl an Pfaden oder eine unendliche Anzahl an Pfaden durch die Anwendung gibt.
Außerdem kann es sein, dass ein Teil der konstruierbaren Pfade nicht ausführbar ist, da sich Bedingungen gegenseitig ausschließen können. Die 
Pfadabdeckung ist in der Praxis also selten erreichbar und daher eher ein theoretisches Vergleichsmaß. 

Als praktikabel hat sich eine eingeschränkte Pfadüberdeckung mit dem Boundary Interior-Verfahren herausgestellt, bei dem Schleifen dreifach getestet werden: 
kein Durchlauf, genau ein Durchlauf und mehrere Durchläufe. Auf unser Beispiel bezogen sind folgende Pfade denkbar: 
1. if-Anweisung und Schleife werden abgewiesen (ggt(30, 10),  
2. if-Anweisung wird durchlaufen und Schleife weist ab (ggt(10, 30) 
3. if-Anweisung und Schleife werden jeweils einmal durchlaufen (ggT(20, 45)), 
4. if-Anweisung wird abgewiesen und Schleife einmal durchlaufen (ggT(45, 20)), 
5. if-Anweisung wird einmal und die Schleife zweimal durchlaufen (ggt(27, 93)) 
6. if-Anweisung wird nicht durchlaufen und Schleife zwei Male (ggt(93, 27)). 

### Bedingungsabdeckung (Condition Coverage) 
Die Bedingungsabdeckung findet dort Anwendung, wo sich Bedingungen in Verzweigungen oder Schleifen aus mehreren Ausdrücken zusammensetzen, 
wie zum Beispiel `if(a<10 || y>20)`. Die Bedingungsabdeckung erfordert, dass jede Bedingung und Teilbedingung mindestens einmal durchlaufen wird 
und einmal true und einmal false ist. Da in unserem Beispiel keine komplexe Bedingung vorkommt, wird hier auf eine Demonstration verzichtet. 


Man merkt: um eine umfassende Testabdeckung zu bekommen, werden Kenntnisse über die Struktur des Quellcodes benötigt. Alle vier 
Testverfahren orientieren sich schließlich am Kontrollfluß des Programms, also darum, welche Anweisungen in welcher Reienfolge ausgeführt 
werden. Tests, bei denen das nötig ist, heißen **White-Box-Tests**.

### Umsetzung in IntelliJ

IntelliJ bietet die Möglichkeit, die Code-Coverage der geschriebenen Tests zu messen. Zur Verfügung stehen dabei die Anweisungs- und die 
Zweigabdeckung. Die Pfadabdeckung wird nicht unterstützt. Dazu müssen die Tests lediglich mit Coverage laufen gelassen werden. Standardmäßig
wählt IntelliJ dabei die Anweisungsüberdeckung, die Zweigüberdeckung muss extra eingestellt werden.

#### Aufgaben

1. Öffne die Klasse `MaexchenTest`, klicke das Häkchen links neben der **Klassenbezeichnung** (um alle Tests und nicht nur einen auszuführen) mit 
rechts an und wähle `Run 'MaexchenTest' with Coverage`. Nun werden die Tests ausgeführt. Das Ergebnis wird dir im rechten oberen Bereich angezeigt. 
2. Wie erklärst du Dir, dass eine Anweisung nicht ausgeführt wird? Korrigiere den Quellcode so, dass du eine 100%ige Anweisungsabdeckung bekommst.
3. Welche Tests wären für eine 100%ige Anweisungsüberdeckung notwendig, also welche(n) Test(s) kann/können gelöscht werden?
4. Nun soll die Zweigabdeckung gemessen werden. Klicke wiederum das Häkchen links neben der Testklassenbezeichnung an und wähle 
`Modify Run Configuration...` aus. Wähle im Konfigurationsfenster unten rechts im Bereich Code Coverage die Option `Modify` und
dort `Use tracing` aus. 
5. Kontrolliere nun die Testabdeckung in beiden Varianten für deine Tests für die Klasse `Gallowsman`. Wie erklärst du dir das Ergebnis
für die Anweisungsüberdeckung? Wie erklärst du dir die gelb markierten Zeilen bei der Zweigüberdeckung?
6. Erzeuge eine 100%ige Anweisungs- und Zweigüberdeckung, indem du einen weiteren Test schreibst, der sicherstellt, dass `guessCharacter()` 
eine IllegalArgument-Exception wirft, sofern ihr kein klein geschriebener Buchstabe übergeben wird. Der Test soll auch die Fehlermeldung der 
Exception auswerten. Formuliere den Test als parametrisierten Test, der viele Zeichen überprüft. Da dieses Mal immer nur ein Parameter an den 
Test übergeben wird, muss keine Csv-Source verwendet werden. Verwende stattdessen Value-Source! Lasse die Tests wiederum mit Coverage laufen.


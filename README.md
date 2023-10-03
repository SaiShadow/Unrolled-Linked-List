# Aufgabe

Eine Unrolled Linked List speichert Elemente in mehreren doppelt verketteten Arrays. Bei der Initialisierung der Liste wird eine Array-Größe 𝑎 > 0 übergeben. Die ersten 𝑎 Elemente werden in einem gemeinsamen Array gespeichert, die nächsten 𝑎 Elemente in einem weiteren Array und so weiter. Die einzelnen Arrays werden doppelt verkettet.
In dieser Aufgabe soll eine Unrolled Linked List in der Klasse UnrolledLinkedList entwickelt werden, die Ganzzahlen (int) speichert. Ihre Implementierung soll die folgenden Operationen unterstützen:
• public UnrolledLinkedList(int arraySize): Konstruktor mit der Array-Größe 𝑎 als einzigem Parameter. Sie können davon ausgehen, dass 𝑎 > 0 ist.
• public boolean push(int element): Einfügen eines Elements am Ende der Liste. Falls ein neues Array angelegt werden musste, so wird true zurückgegeben, ansonsten false.
• public boolean pop(): Entfernen des Elements am Ende der Liste. Falls ein Array entfernt wurde, so soll true zurückgegeben werden, ansonsten false. Gehen Sie davon aus, dass pop() nicht auf einer leeren Liste aufgerufen wird.
• public int get(int i): Erhalten des Elements an Position 𝑖. Gehen Sie davon aus, dass 𝑖 ≥ 0 gilt und 𝑖 immer kleiner als die Anzahl der aktuell gespeicherten Elemente ist.
• public int size(): Erhalten der Anzahl der aktuell gespeicherten Elemente.
• public String toString(String separator): Gibt alle Elemente der Liste auf- steigend nach Index sortiert als eine neue Zeichenkette zurück. Die Elemente werden in einer Zeile und durch den als Parameter übergebenen Separator getrennt zurückgegeben.

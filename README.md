# Shop_APP

Aplicatia de cumpărare / vânzare

Membri echipei: Janțu Petre-Marin , Darjan Paunovic

Tecnologi folosite
Java 16
JavaFX 16 (as GUI)
Maven (Build Tool)
Json Type (as local database)

Descriere generala: 
Această aplicaţie ar trebui să ajute utilizatori sa poata sa isi expuna produsele spre vanzare
mai usor si tot odata cumparatori sa achizitioneze de ei tot prin intermediul aplicatiei.

Înregistrare (pentru vânzător si administrator):
1. Utilizatorul trebuie să se înregistreze mai întâi în aplicație selectând unul dintre cele două 
roluri:cumpărător sau vânzător.
Ambele roluri necesită un nume de utilizator unic, si o parolă. 

Cumpărător:

0. Utilizatorul trebuie sa se autentifice in aplicatie cu un cont de cumparator pentru 
a accesa functiile prevazute cumparatorului.

1. Cumpărătorul poate vedea toate produsele care sunt de vânzare

2. Cumpărătorul poate vedea toate produsele pe care le-a cumpărat deja dar si statusul 
in care un produs anume se afla (comanda ajunsa la vanzator/in curs de livrare/produs livrat).
Livrarea produsului este confirmata de cumparator.

3. Cumpărătorul poate cauta un produs anume in lista de produse sau chiar pe categorii de 
produse( ex:alimentare, electrocasnice etc)

4. Cumpărătorul comanda orice produs din toate produsele care sunt de vânzare.

5.Acesta are posibilitate de a platit online prin intermediul aplicatiei dar si prin celelalte 
metode deja folosite(ramburs,ridicare colet)

6.Acesta poate lasa un review vanzatorului si poate aprecia sau nu produsul pe un sistem de 
rating de la 1 la 10.

Vânzător:

0. Utilizatorul trebuie sa se autentifice in aplicatie cu un cont de vanzator pentru a accesa 
functiile prevazute vanzatorului.

1. Poate vedea toate produsele pe care le-a vândut.

2. Poate adăuga produse noi de vânzare, poate șterge un produs sau poate modifica unul
existent.Un produs are specificati obligatorii (nume,pret) dar si specificati optionale(descriere,origine,etc).

3. Poate confirma ca comanda a ajuns la el si modifica starea produsului.Odata finalizata
(ajunge in starea produs livrat) comanda acesta primeste bani din vanzarea produsului in cazul 
in care metoda de plata este prin aplicatie.

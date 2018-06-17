Aplicatia a fost realizata in Java proiectul fiind scris in Intellij.

Aceasta contine o baza de date "oprea". Baza de date MySQL contine tabelele "courses", "students", "users" si tabela "students_courses" care este tabela de legatura creata in mod automat intre "courses" si "students" ca urmare a relatiei many-to-many a celor 2 tabele.

Tabela users este utilizata pentru a realiza login-ul pentru utilizarea aplicatiei. Datele din tabela "users" trebuiesc adaugate prin intermediul bazei de date deoarece nu am realizat signup-ul din interiorul aplicatiei. Aplicatia porneste cu requestul de login in "/user/login".

Dupa login prin intermediul aplicatiei se pot popula tabele "courses" "/user/addCurs", "students" "/user/addStud", dupa care afisarea datelor din tabele se poate face cu request tip get la "/user/getAllStud" respectiv "/user/getAllCourses".

Modificarea datelor din tabela respectiv update si delete se realizeaza doar pentru datele din tabela "courses" la "/user/updateCurs/{cursId}" si "user/deleteCurs/{cursId}".

Legatura dintre cele 2 tabele "courses" si "students" poate fi exemplificata prin request de tip put la "/addStudentToCourses/{cursId}"

Dupa realizarea consistentei datelor se poate realiza o afisare a cursurilor si a tuturor studentilor ce participa la cursuri printr-un request de tip get "/user/showCoursesWithStudents" dar si a tuturor studentilor si cursurile la care acestia sunt inscrisi "/user/showStudentsWithCourses"

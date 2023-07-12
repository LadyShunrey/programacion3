package EJ_02;

/*Problema de la Mochila. Se tienen n objetos y una mochila. Para i = 1,2,..n, el objeto i tiene un
peso positivo pi y un valor positivo vi. La mochila puede llevar un peso que no sobrepase P. El
objetivo es llenar la mochila de tal manera que se maximice el valor de los objetos transportados,
respetando la limitación de capacidad impuesta. Los objetos pueden ser fraccionados, si una
fracción xi (0 ≤ xi ≤ 1) del objeto i es ubicada en la mochila contribuye en xipi al peso total de la
mochila y en xivi al valor de la carga. Formalmente, el problema puede ser establecido como.
			     𝑛                                                                                 𝑛
Maximizar i = ∑xivi , con la restricción i = ∑xipi ≤ P donde vi>0, pi>0 y 0 ≤ xi ≤ 1 para 1 ≤ i ≤ n.
			  1                              1
Por ejemplo, para la instancia en n = 3 y P = 20
(v1, v2, v3) = (25, 24, 15)
(p1, p2, p3) = (18, 15, 10)
Algunas soluciones posibles son:
(x1, x2, x3) xipi xivi
(½, ⅓, ¼) 16.5 24.25
(1, 2/15, 0) 20 28.2
(0, ⅔, 1) 20 31
(0, 1, ½) 20 31.5
Puede observarse que (0, 1, ½) produce el mayor beneficio.
*/

public class EJ_02 {
	//IDEA: Candidatos= n objetos, Solucion = mochila vacia
	public static void main(String[] args) {

	}

}

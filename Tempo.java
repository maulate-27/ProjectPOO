package pacote1.electronicos;

import java.util.*;
import java.text.*;
import java.time.*;

public class Tempo{
	SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy  hh:mm:ss");
	Date date = new Date();
	String dataFormatada = formatter.format(date);
}

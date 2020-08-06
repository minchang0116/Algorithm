package BOJ.입출력;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class Test10699 {

	public static void main(String[] args) {

		SimpleDateFormat mSimpleDateFormat = new SimpleDateFormat ( "yyyy-MM-dd", Locale.KOREA );
		Date currentTime = new Date ();
		String mTime = mSimpleDateFormat.format ( currentTime );
		System.out.println ( mTime );


	}

}

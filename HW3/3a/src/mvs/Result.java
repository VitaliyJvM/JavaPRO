package mvs;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.*;

@SuppressWarnings("serial")
public class Result extends HttpServlet {

    enum Season {winter, spring, summer, autumn}

    enum Dayperiod {morning, day, evening, night}

    enum Sex {male, female}

    static private Map<Season, Integer> seasonMap = new HashMap<>();
    static private Map<Dayperiod, Integer> dayperiodMap = new HashMap<>();
    static private Map<Sex, Integer> sexMap = new HashMap<>();

    static final String TEMPLATEstart = "<html>" +
            "<head><meta charset=\"utf-8\"><title>Prog.kiev.ua</title></head><body>" +
            "<h2>Спасибо за ваши ответы!</h2><br>" +
            "<h1>Статистика ответов:</h1>";

    static final String TEMPLATE1 = "<p><b>Любимая пора года:</b></p>" + "%s" + "<br>";
    static final String TEMPLATE2 = "<p><b>Любимое время дня:</b></p>" + "%s" + "<br>";
    static final String TEMPLATE3 = "<p><b>Больше отвечали:</b></p>" + "%s" + "<br>";

    static final String TEMPLATEend = "</body></html>";

    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        Season season = Season.valueOf(req.getParameter("season"));
        Dayperiod dayperiod = Dayperiod.valueOf(req.getParameter("dayperiod"));
        Sex sex = Sex.valueOf(req.getParameter("sex"));

        seasonMap.put(season, (seasonMap.containsKey(season)) ? seasonMap.get(season) + 1 : 1);
        dayperiodMap.put(dayperiod, (dayperiodMap.containsKey(dayperiod)) ? dayperiodMap.get(dayperiod) + 1 : 1);
        sexMap.put(sex, (sexMap.containsKey(sex)) ? sexMap.get(sex) + 1 : 1);

        Map.Entry<Season, Integer> maxSeason = null;
        Map.Entry<Dayperiod, Integer> maxDayperiod = null;
        Map.Entry<Sex, Integer> maxSex = null;

        for (Map.Entry<Season, Integer> entry : seasonMap.entrySet()) {
            if (maxSeason == null || entry.getValue().compareTo(maxSeason.getValue()) > 0) {
                maxSeason = entry;
            }
        }
        for (Map.Entry<Dayperiod, Integer> entry : dayperiodMap.entrySet()) {
            if (maxDayperiod == null || entry.getValue().compareTo(maxDayperiod.getValue()) > 0) {
                maxDayperiod = entry;
            }
        }
        for (Map.Entry<Sex, Integer> entry : sexMap.entrySet()) {
            if (maxSex == null || entry.getValue().compareTo(maxSex.getValue()) > 0) {
                maxSex = entry;
            }
        }

        resp.setContentType("text/html; charset=utf-8");

        String s1 = seasonMap.entrySet().stream()
                .map(p -> p.getKey().toString()+" - "+p.getValue().toString()+" &nbsp; &nbsp; &nbsp; &nbsp; ")
                .reduce("", (a, b) -> a + b);

        String s2 = dayperiodMap.entrySet().stream()
                .map(p -> p.getKey().toString()+" - "+p.getValue().toString()+" &nbsp; &nbsp; &nbsp; &nbsp; ")
                .reduce("", (a, b) -> a + b);

        String s3 = sexMap.entrySet().stream()
                .map(p -> p.getKey().toString()+" - "+p.getValue().toString()+" &nbsp; &nbsp; &nbsp; &nbsp; ")
                .reduce("", (a, b) -> a + b);

        resp.getWriter().println(TEMPLATEstart +
                String.format(TEMPLATE1, s1) + String.format(TEMPLATE2, s2) + String.format(TEMPLATE3, s3) +
                TEMPLATEend);

    }

}

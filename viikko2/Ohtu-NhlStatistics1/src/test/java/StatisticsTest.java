import java.util.ArrayList;
import java.util.List;
import ohtuesimerkki.Player;
import ohtuesimerkki.Reader;
import ohtuesimerkki.Statistics;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;


public class StatisticsTest {

    Statistics stats;
    Reader readerStub = new Reader() {

        public List<Player> getPlayers() {
            ArrayList<Player> players = new ArrayList<Player>();

            players.add(new Player("Semenko", "EDM", 4, 12));
            players.add(new Player("Lemieux", "PIT", 45, 54));
            players.add(new Player("Kurri",   "EDM", 37, 53));
            players.add(new Player("Yzerman", "DET", 42, 56));
            players.add(new Player("Gretzky", "EDM", 35, 89));

            return players;
        }
    };

    public StatisticsTest() {
        stats = new Statistics(readerStub);
    }

    @Test
    public void searchWorks() {
        assertEquals((String.format("%-20s", "Kurri") + " " + "EDM" + " " + String.format("%2d",37) + " + "
                + String.format("%2d",53) + " = " + 90), stats.search("Kurri").toString());
    }

    @Test
    public void teamListWorks() {
        assertEquals("[Semenko              EDM  4 + 12 = 16, Kurri                EDM 37 + 53 = 90, Gretzky              EDM 35 + 89 = 124]", stats.team("EDM").toString());
    }

    @Test
    public void topScorersWorks() {
        assertEquals("[Gretzky              EDM 35 + 89 = 124, Lemieux              PIT 45 + 54 = 99]", stats.topScorers(1).toString());
    }

    @Test
    public void searchFails() {
        assertEquals(null, stats.search("pollo"));
    }

}

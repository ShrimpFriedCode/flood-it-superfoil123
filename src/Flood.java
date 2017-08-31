import java.util.List;
import java.util.Map;
//removed unnecessary imports, reduced run-time

//Collaborated with Drazzo

public class Flood {

    // Students implement this flood function.

    public static void flood2(WaterColor color, List<Coord> flooded_list, Map<Coord,Tile> tiles, Integer board_size) { //started from scratch, still can't improve times ~270
        for (int i = 0; i < flooded_list.size(); i++) {
            Coord[] nbor = flooded_list.get(i).neighbors(board_size).toArray(new Coord[flooded_list.get(i).neighbors(board_size).size()]); //array for speed
            for (Coord c : nbor) {
                if ((tiles.get(c).getColor().equals(color)) && !flooded_list.contains(c)) { //more compact comparison
                    flooded_list.add(c);
                }
            }
        }
    }

    public static void flood1(WaterColor color, List<Coord> flooded_list, Map<Coord,Tile> tiles, Integer board_size) // worst time, ~250
    {
        for (int i=0; i<flooded_list.size();i++) { //For some reason, enhanced for loops cause errors here
            Coord[] neigh = flooded_list.get(i).neighbors(board_size).toArray(new Coord[flooded_list.get(i).neighbors(board_size).size()]); //messy, but works?
            for (int n=0; n<neigh.length;n++) {
                Tile t = tiles.get(neigh[n]); //array indexing faster than get function, possible speed improvement
                if (t.getColor().equals(color)) {
                    if (!(flooded_list.contains(t.getCoord()))) { //all of this really can't be different
                        flooded_list.add(t.getCoord());
                    }
                }
            }
        }
    }

    public static void flood(WaterColor color, List<Coord> flooded_list, Map<Coord,Tile> tiles, Integer board_size) //Fastest, top time of ~190
    {
        for (int i=0; i<flooded_list.size();i++) { //For some reason, enhanced for loops cause errors here
            Coord c = flooded_list.get(i); //possible memory optimization
            List<Coord> neigh = c.neighbors(board_size); //heavy possibility for speed improvement
            for (Coord n : neigh) { //
                Tile t = tiles.get(n); //assignment needed for speed; no optimization needed
                if (t.getColor().equals(color)) { //can't improve
                    if (!(flooded_list.contains(t.getCoord()))) {
                        flooded_list.add(t.getCoord());
                    }
                }
            }
        }
    }
}

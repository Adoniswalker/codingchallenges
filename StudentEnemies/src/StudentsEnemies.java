//A teacher must divide a class of students into two teams to play dodgeball.
// Unfortunately, not all the kids get along, and several refuse to be put on
// the same team as that of their enemies.
//
//        Given an adjacency list of students and their enemies,
//        write an algorithm that finds a satisfactory pair of teams, or returns False if none exists.
//
//        For example, given the following enemy graph you should return the teams {0, 1, 4, 5} and {2, 3}.
//
//        students = {
//        0: [3],
//        1: [2],
//        2: [1, 4],
//        3: [0, 4, 5],
//        4: [2, 3],
//        5: [3]
//        }
//    0-> 1, 2,4,5
//    1-> 0 3  4 5
//    2-> 0 3 5
//    3-> 1 2
//    4-> 1, 0, 5
//    5-> 1,2,4
// Team A-> 0, 1,4,5
// Team B->2,3
//        On the other hand, given the input below, you should return False.
//
//        students = {
//        0: [3],
//        1: [2],
//        2: [1, 3, 4],
//        3: [0, 2, 4, 5],
//        4: [2, 3],
//        5: [3]
//        }

import org.w3c.dom.ls.LSOutput;

import java.util.*;

public class StudentsEnemies {

    public static void main(String[] args) {
        Map<Integer, Set<Integer>> map = new HashMap<>();
        map.put(2, Set.of(1, 4));
        map.put(3, Set.of(0, 4, 5));
        map.put(4, Set.of(2, 3));
        map.put(5, Set.of(3));

        Map<Integer, Set<Integer>> students = new HashMap<>();
        students.put(0, Set.of(3));
        students.put(1, Set.of(2));
        students.put(2, Set.of(1, 3, 4));
        students.put(3, Set.of(0, 2, 4, 5));
        students.put(4, Set.of(2, 3));
        students.put(5, Set.of(3));

        StudentsEnemies student_enemies = new StudentsEnemies();
        student_enemies.calculateTeams(map);
        System.out.println("Map two\n\n\n\n\n");
        student_enemies.calculateTeams(students);

    }
    private void calculateTeams(Map<Integer, Set<Integer>> map){
        Set<Integer> teamA = new HashSet<>();
        Set<Integer> teamB = new HashSet<>();
        for (Map.Entry<Integer, Set<Integer>> entry : map.entrySet()) {
            //For initial start add values to teamA and team B in position 0
            if(teamA.isEmpty()){
                teamA.add(entry.getKey());
                teamB.addAll(entry.getValue());
            }
            //Check if we have key in team A
            if (teamA.contains(entry.getKey())) {
                teamB.addAll(entry.getValue());
                System.out.println("Team A has key "+entry.getKey());
            }
            //check if we have values in team B
            else if(teamB.contains(entry.getKey())){
                teamA.addAll(entry.getValue());
                System.out.println("Team B has key "+entry.getKey());
            }
            if(teamA.contains(entry.getKey()) && teamB.contains(entry.getKey())){
                System.out.println(entry.getKey()+" cannot be on same team");
                break;
            }
            System.out.println("TeamA  "+ teamA+ "  teamB "+teamB);

            Set<Integer> differenceTeamB = new HashSet<>(teamB);
            differenceTeamB.retainAll(entry.getValue());
            Set<Integer> differenceTeamA = new HashSet<>(teamA);
            differenceTeamA.retainAll(entry.getValue());
            //check if we have any intersection values in team B
            if (! differenceTeamB.isEmpty()) {
                teamA.add(entry.getKey());
                teamB.addAll(entry.getValue());
                System.out.println("differenceTeamB "+differenceTeamB);
            }
            else if(!differenceTeamA.isEmpty()){
                teamB.add(entry.getKey());
                teamA.addAll(entry.getValue());
                System.out.println("differenceTeamA "+differenceTeamA);
            }
            System.out.println("TeamA  "+ teamA+ " teamB "+teamB);
        }
        System.out.println("teamA " + teamA);
        System.out.println("teamB " + teamB);
    }
}

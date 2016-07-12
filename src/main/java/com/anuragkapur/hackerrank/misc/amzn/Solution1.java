package com.anuragkapur.hackerrank.misc.amzn;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/**
 * @author anuragkapur
 */
public class Solution1 {


    public List<String> getDirectFriendsForUser(String user) {
        return null;
    }

    public List<String> getAttendedCoursesForUser(String user) {
        return null;
    }


    public List<String> getRankedCourses(String user) {

        /*
         1. create social network (friends, no more than 2 levels away in the social graph)
         */

        // using set to prevent duplicates that may arise via common friends
        Set<String> socialNetwork = new HashSet<String>();

        List<String> firstLevelFriends = getDirectFriendsForUser(user);
        socialNetwork.addAll(firstLevelFriends);
        for (String friend : firstLevelFriends) {
            // get second level friends
            socialNetwork.addAll(getDirectFriendsForUser(friend));
        }
        // remove the "user in question" itself, that would get added via direct friends of first level friends.
        socialNetwork.remove(user);

        /*
         2. list of courses already attended by user
         */
        List<String> coursesAlreadyTaken = getAttendedCoursesForUser(user);

        /*
         3. get candidate courses
         */
        // network courses map, with 'course' as 'key' and its 'attendance count' as 'value'
        Map<String, Integer> networkCourses = new HashMap<String, Integer>();

        for (String friend : socialNetwork) {
            for (String course : getAttendedCoursesForUser(friend)) {
                if (!coursesAlreadyTaken.contains(course)) {
                    // user hasn't already taken the course taken by a user. It is thus a candidate course
                    if (networkCourses.containsKey(course)) {
                        int attendanceCount = networkCourses.get(course);
                        // increment attendance count
                        networkCourses.replace(course, attendanceCount+1);
                    }
                }
            }
        }

        /*
         4. prepare ranked recommendations, by sorting networkCourses by their attendance count
         */
        Comparator<String> comparator = new ValueComparator<String, Integer>(networkCourses);
        TreeMap<String, Integer> sortedByAttendanceNetworkCourses = new TreeMap<String, Integer>(comparator);
        sortedByAttendanceNetworkCourses.putAll(networkCourses);

        List<String> recommendations = new ArrayList<String>();
        recommendations.addAll(sortedByAttendanceNetworkCourses.keySet());

        return recommendations;
    }

    class ValueComparator<K, V extends Comparable<V>> implements Comparator<K> {

        private Map<K, V> map = new HashMap<K, V>();

        public ValueComparator(Map<K, V> map){
            this.map.putAll(map);
        }

        public int compare(K s1, K s2) {
            return -map.get(s1).compareTo(map.get(s2));
        }
    }
}

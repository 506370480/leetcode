package graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class AllPathsSourceTarget {
    static List<List<Integer>> list = new LinkedList<>();
    public static void main(String[] args) {
        int[][] graph = new int[][]{{1,2},{3},{3},{}};
        allPathsSourceTarget(graph);
    }
    //ʹ���ڽӱ�����ʾ��graph[i] �洢��ڵ� i �������ھӽڵ�
    public static List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        LinkedList<Integer> path = new LinkedList<>();
        traverse(graph,0,path);
        return list;
    }
    public static void traverse(int[][] graph, int s, LinkedList<Integer> path){
        path.add(s);
        int n = graph.length;
        if(s==n-1){
            list.add(new ArrayList<>(path));
            path.removeLast();
            return;
        }
        for (int v : graph[s]) {
            traverse(graph,v,path);
        }
        path.removeLast();
    }
}

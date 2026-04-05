package dsa.unionFind;


    /*
    Union find ( disjoint set )

    tracks a set of elements partitioned into disjoint subsets. Supports near constant time union and find
    operations using union by size and path compression/ collapsing find

    - use cases
        - Kruskal minimum spanning tree algorithm
        - Detecting cycles in undirected graphs
        - Connected components in dynamic graphs



        { -1 , 0, 1 , 2 , 3 , 4}
     */



public class UnionFind {

    private int size;
    private int[] parent;
    private int[] sz;
    private int numComponent;

    public UnionFind(int size) {
        if (size <= 0) throw new IllegalArgumentException("positive numbers only ");

        this.size = size;
        this.numComponent = size;
        this.parent = new int[size];
        this.sz = new int[size];

        for (int i = 0; i < size; i++) {
            this.parent[i] = -1;
            this.sz[i] = i;
        }
    }

    /*
    find the root of the set/component containing element p
    uses path compression to flatten the tree structure

    @param p the element to find the root of
    @return the root of the set/component/mini-tree

     */

    public int find(int p) {
        // base case
        if (parent[p] < 0) return p;
        return parent[p] = find(parent[p]);
    }

    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }

    public int componentSize(int p) {
        // get the parent of index p
        int parent = find(p);
        return parent > 0 ? parent : parent * (-1);
    }


    public int getSize() {
        return this .size;
    }

    public int disjointSets() {
        return numComponent;
    }


    // this functon merges sets /components containing elements p and q
    public void union(int p, int q) {
        int root1 = find(p);
        int root2 = find(p);

        // this mean they are in the same set /components and it will create a cycle;
        if (root1 == root2) return;
    }




}

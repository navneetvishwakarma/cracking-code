package tarang.topcoder;


import java.util.*;

/**
 * Attempt at 1000 point top coder question. http://j2eecode.blogspot.com/2009/12/topcoder-prerequisites.html
 *
 * @author tdesai
 */
public class Prerequisites {

    private void sort(ClassNode node, List<String> result) {
        for(ClassNode prereq : node.getPrereqs()) {
            if (!prereq.isVisited()) {
                sort(prereq, result);
            }
        }
        result.add(node.toString());
        node.setVisited(true);
    }

    public String[] orderClasses(String[] strs) {
        Map<String, ClassNode> classes = new HashMap<String, ClassNode>();
        for(String classstr : strs) {
            String[] tokens = classstr.split(" ");
            if(tokens.length == 0) {
                return new String[]{};
            }
            ClassNode temp = new ClassNode(tokens[0], true);
            ClassNode orig = classes.get(temp.toString());
            if(orig == null) {
                orig = temp;
                classes.put(orig.toString(), orig);
            } else {
                orig.setEntry(true);
            }

            for(int i = 1; i < tokens.length; i++) {
                temp = new ClassNode(tokens[i], false);
                ClassNode prereq = classes.get(temp.toString());
                if(prereq == null) {
                    prereq = temp;
                    classes.put(prereq.toString(), prereq);
                }
                if(!orig.addPrereq(prereq)) {
                    return new String[]{};
                }
            }
        }
        for(ClassNode node : classes.values()) {
            if(!node.isEntry()) {
                return new String[]{};
            }
        }
        // create the list of classes
        List<String> result = new LinkedList<String>();
        for(ClassNode node : new TreeSet<ClassNode>(classes.values())) {
            if (!node.isVisited()) {
                sort(node, result);
            }
        }
        return result.toArray(new String[result.size()]);
    }

/*    public static void main(String[] args) {
        String[] classes = new String[]{
                "CSE258: CSE244 CSE243 INTR100",
                "CSE221: CSE254 INTR100",
                "CSE254: CSE111 MATH210 INTR100",
                "CSE244: CSE243 MATH210 INTR100",
                "MATH210: INTR100",
                "CSE101: INTR100",
                "CSE111: INTR100",
                "ECE201: CSE111 INTR100",
                "ECE111: INTR100",
                "CSE243: CSE254",
                "INTR100:"
        };

        *//*classes = new String[]{
                "ENGL111: ENGL110"
        };*//*

        new Prerequisites().orderClasses(classes);
    }*/
}

class ClassNode implements Comparable {
    private String dept;
    private Integer classNum;
    private Set<ClassNode> prereqs;
    private boolean visited;
    private boolean entry;

    public ClassNode(String classDeptNum, boolean entry) {
        if(classDeptNum.endsWith(":")) {
            classDeptNum = classDeptNum.substring(0, classDeptNum.length()-1);
        }
        this.classNum = Integer.valueOf(classDeptNum.substring(classDeptNum.length() - 3, classDeptNum.length()));
        this.dept = classDeptNum.substring(0, classDeptNum.indexOf(this.classNum + ""));

        this.visited = false;
        this.entry = entry;
    }

    public String getDept() {
        return dept;
    }

    public Integer getClassNum() {
        return classNum;
    }

    public Set<ClassNode> getPrereqs() {
        if(prereqs == null) {
            this.prereqs = new TreeSet<ClassNode>();
        }
        return prereqs;
    }

    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    public boolean isEntry() {
        return entry;
    }

    public void setEntry(boolean entry) {
        this.entry = entry;
    }

    public boolean addPrereq(ClassNode node) {
        if(node.getPrereqs().contains(this)) {
            return false;
        }
        this.prereqs.add(node);
        return true;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        ClassNode classNode = (ClassNode) o;

        if (!classNum.equals(classNode.classNum)) {
            return false;
        }
        if (!dept.equals(classNode.dept)) {
            return false;
        }

        return true;
    }

    @Override
    public int hashCode() {
        int result = dept.hashCode();
        result = 31 * result + classNum.hashCode();
        return result;
    }

    public int compareTo(Object o) {
        if (this == o) {
            return 0;
        }

        ClassNode that = (ClassNode) o;

        if(this.classNum.equals(that.getClassNum()) && this.dept.equals(that.getDept())) {
            return 0;
        }

        if(this.classNum < that.getClassNum()) {
            return -1;
        } else if(this.classNum > that.getClassNum()) {
            return 1;
        } else {
            return this.getDept().compareTo(that.getDept());
        }
    }

    @Override
    public String toString() {
        return dept + classNum;
    }
}

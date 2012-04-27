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
            if (!prereq.visited) {
                sort(prereq, result);
            }
        }
        result.add(node.toString());
        node.visited = true;
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
                orig.entry = true;
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
            if(!node.entry) {
                return new String[]{};
            }
        }
        // create the list of classes
        List<String> result = new LinkedList<String>();
        for(ClassNode node : new TreeSet<ClassNode>(classes.values())) {
            if (!node.visited) {
                sort(node, result);
            }
        }
        return result.toArray(new String[result.size()]);
    }
}

class ClassNode implements Comparable {
    String dept;
    Integer classNum;
    Set<ClassNode> prereqs;
    boolean visited;
    boolean entry;

    public ClassNode(String classDeptNum, boolean entry) {
        if(classDeptNum.endsWith(":")) {
            classDeptNum = classDeptNum.substring(0, classDeptNum.length()-1);
        }
        this.classNum = Integer.valueOf(classDeptNum.substring(classDeptNum.length() - 3, classDeptNum.length()));
        this.dept = classDeptNum.substring(0, classDeptNum.indexOf(this.classNum + ""));
        this.visited = false;
        this.entry = entry;
    }

    public Set<ClassNode> getPrereqs() {
        if(prereqs == null) {
            this.prereqs = new TreeSet<ClassNode>();
        }
        return prereqs;
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
        if (this == o) { return true; }
        if (o == null || getClass() != o.getClass()) { return false; }
        ClassNode classNode = (ClassNode) o;
        if (!classNum.equals(classNode.classNum)) {
            return false;
        }
        if (!dept.equals(classNode.dept)) {
            return false;
        }

        return true;
    }

    public int hashCode() {
        int result = dept.hashCode();
        result = 31 * result + classNum.hashCode();
        return result;
    }

    public int compareTo(Object o) {
        if (this == o) { return 0; }
        ClassNode that = (ClassNode) o;
        if(this.classNum.equals(that.classNum) && this.dept.equals(that.dept)) { return 0; }
        if(this.classNum < that.classNum) {
            return -1;
        } else if(this.classNum > that.classNum) {
            return 1;
        } else {
            return this.dept.compareTo(that.dept);
        }
    }

    public String toString() {
        return dept + classNum;
    }
}

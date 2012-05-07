package tarang.lulu;

import java.util.*;

/**
 * Put class JavaDoc here
 *
 * @author mmathuria
 */
class NoName
{
    Map<String,NoName> children = new LinkedHashMap<String, NoName>();
    String name = "";

    boolean hasChild(String child) {
        return this.children.containsKey(child);
    }

    private NoName addChild(String child) {
        NoName childnode = new NoName();
        childnode.name = child;
        this.children.put(child,childnode);
        return childnode;
    }

    private NoName getNode(String child) {
        if (this.hasChild(child))
            return this.children.get(child);
        else
            return this.addChild(child);
    }

    void addList(String input) {
        NoName currentNode = this.getNode(input.charAt(0)+"");
        input = input.substring(1, input.length());
        if (input.length() < 1)
            currentNode.getNode("");
        else
            currentNode.addList(input);
    }

    private String scan()
    {
        if (this.children.values().size() == 0)
            return this.name;
        if (this.children.values().size() == 1){
            return this.name + ((NoName)children.values().toArray()[0]).scan();
        }

        List<String> temp = new ArrayList<String>();
        for(NoName nn : children.values()){
            temp.add(nn.scan());
        }

        Arrays.sort(temp.toArray());
        String s = "";
        for(String s1 : temp){
            s += "," + s1;
        }
        return this.name + "{" + s + "}";
    }


    public static void main(String[] args) {
        NoName x = new NoName();
        x.addList(" /home/user/foo");
        x.addList(" /home/user/bar");
        x.addList(" /home/user/baz/one");
        x.addList(" /home/user/baz/two");

        System.out.println(x.scan());
    }
}
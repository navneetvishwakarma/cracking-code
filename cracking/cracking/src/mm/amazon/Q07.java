package mm.amazon;

import mm.ds.BinaryTree;
import mm.ds.TreeNode;

import java.util.HashMap;
import java.util.Map;


/**
 * Find the maximum sum path in a binary tree
 *
 * @author mmathuria
 */
public class Q07 {
    
    public Map<String,Object> maxPath(BinaryTree btree){
        return _maxPath(btree.getRoot());
    }
    
    private Map<String,Object> _maxPath(TreeNode current){
        if(current == null){
            return null;
        }
        
        
        Map<String,Object> leftMap = _maxPath(current.leftChild);
        Map<String, Object> rightMap =  _maxPath(current.rightChild);
        
        Map<String,Object> resultMap;
        if(leftMap == null && rightMap == null){
            Map<String,Object> map = new HashMap<String,Object>();
            String nodeName = Integer.toString(current.getData());
            map.put("path",nodeName);
            map.put("sum",current.getData());
            resultMap = map;
        }else if(leftMap == null){
            updateMap(current, rightMap);
            resultMap = rightMap;
        }else if(rightMap == null){
            updateMap(current, leftMap);
            resultMap = leftMap;
        }else{
            int leftSum = (Integer)leftMap.get("sum");
            int rightSum = (Integer)rightMap.get("sum");
            Map<String,Object> biggerMap = (leftSum > rightSum) ? leftMap : rightMap;
            updateMap(current,biggerMap);
            resultMap = biggerMap;
        }
        return resultMap;
    }

    private void updateMap(TreeNode current, Map<String, Object> map) {
        String nodeName = Integer.toString(current.getData());
        String updatedPath = nodeName + map.get("path");
        Integer updateSum = current.getData() + ((Integer) map.get("sum"));
        map.put("sum",updateSum);
        map.put("path",updatedPath);
    }
}

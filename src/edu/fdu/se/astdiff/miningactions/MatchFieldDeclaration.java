package edu.fdu.se.astdiff.miningactions;

import com.github.gumtreediff.actions.model.Action;
import com.github.gumtreediff.actions.model.Delete;
import com.github.gumtreediff.actions.model.Insert;
import com.github.gumtreediff.tree.ITree;
import com.github.gumtreediff.tree.TreeContext;
import edu.fdu.se.astdiff.miningoperationbean.ClusteredActionBean;
import edu.fdu.se.gumtree.MyTreeUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class MatchFieldDeclaration {
    public static ClusteredActionBean matchFieldDeclaration(MiningActionData fp, Action a, String nodeType) {
        String operationEntity  = "FIELDDECLARATION";

        List<Action> allActions = new ArrayList<Action>();
        int status = MyTreeUtil.traverseNodeGetAllEditActions(a, allActions);
        fp.setActionTraversedMap(allActions);

        TreeContext con = null;
        if (a instanceof Insert) {
            con = fp.getDstTree();
        } else if (a instanceof Delete) {
            con = fp.getSrcTree();
        }
        ITree nodeContainVariableDeclarationFragment = AstRelations.isChildContainVariableDeclarationFragment(a.getNode(), con);
        if (nodeContainVariableDeclarationFragment != null && nodeContainVariableDeclarationFragment.getChildren().size()>1) {
            operationEntity += "-OBJECT-INITIALIZING";
            if (AstRelations.isClassCreation(allActions, con)) {
                operationEntity += "-NEW";
            }
        }

        ClusteredActionBean mHighLevelOperationBean = new ClusteredActionBean(
                a,nodeType,allActions,status,operationEntity,null,null);
        return mHighLevelOperationBean;
    }
    public static ClusteredActionBean matchFieldDeclarationByFather(MiningActionData fp, Action a, String nodeType, ITree fafafatherNode, String ffFatherNodeType) {
        String operationEntity  = "FATHER-FIELDDECLARATION";

        List<Action> allActions = new ArrayList<Action>();
        ITree srcfafafather = null;
        ITree dstfafafather = null;
        if (a instanceof Insert) {
            dstfafafather = fafafatherNode;
            srcfafafather = fp.getMappedSrcOfDstNode(dstfafafather);
            if (srcfafafather == null) {
                System.err.println("err null mapping");
            }
        } else {
            srcfafafather = fafafatherNode;
            dstfafafather = fp.getMappedDstOfSrcNode(srcfafafather);
            if (dstfafafather == null) {
                System.err.println("err null mapping");
            }
        }

        Set<String> srcT = MyTreeUtil.traverseNodeGetAllEditActions(srcfafafather, allActions);
        Set<String> dstT = MyTreeUtil.traverseNodeGetAllEditActions(dstfafafather, allActions);
        int status = MyTreeUtil.isSrcOrDstAdded(srcT,dstT);
        fp.setActionTraversedMap(allActions);

        TreeContext con = null;
        if (a instanceof Insert) {
            con = fp.getDstTree();
        } else if (a instanceof Delete) {
            con = fp.getSrcTree();
        }
        ITree nodeContainVariableDeclarationFragment = AstRelations.isChildContainVariableDeclarationFragment(fafafatherNode, con);
        if (nodeContainVariableDeclarationFragment != null && nodeContainVariableDeclarationFragment.getChildren().size()>1) {
            operationEntity += "-OBJECT-INITIALIZING";
            if (AstRelations.isClassCreation(allActions, con)) {
                operationEntity += "-NEW";
            }
        }

        ClusteredActionBean mHighLevelOperationBean = new ClusteredActionBean(
                a,nodeType,allActions,status,operationEntity,fafafatherNode,ffFatherNodeType);
        return mHighLevelOperationBean;
    }
}
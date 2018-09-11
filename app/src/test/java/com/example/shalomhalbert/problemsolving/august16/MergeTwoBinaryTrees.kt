package com.example.shalomhalbert.problemsolving.august16

/**
 * Not a unit test because the task doesn't involve creating a binary tree
 */
class MergeTwoBinaryTrees {


    fun mergeTrees(t1: TreeNode?, t2: TreeNode?): TreeNode? {
        //Reached the end of the tree
        when {
            t1 == null -> return t2
            t2 == null -> return t1
        }
        //Merge trees
        val mergedTree = TreeNode(t1!!.`val` + t2!!.`val`)
        mergedTree.left = mergeTrees(t1!!.left, t2.left)
        mergedTree.right = mergeTrees(t1.right, t2.right)
        //Return merged tree
        return t1
    }

    /**
     * Pre-defined class
     *
     */
    class TreeNode(var `val`: Int = 0) {
        var left: TreeNode? = null
        var right: TreeNode? = null

    }

}
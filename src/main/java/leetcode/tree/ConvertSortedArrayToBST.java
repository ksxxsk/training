package leetcode.tree;

/**
 * Given an array where elements are sorted in ascending order, convert it to a height balanced BST.
 */
public class ConvertSortedArrayToBST {

    public TreeNode sortedArrayToBST(int[] nums) {

        return arrayToBST(nums, 0, nums.length - 1);
    }

    private TreeNode arrayToBST(int[] nums, int start, int end) {
        if (end < start)
            return null;

        int mid = (end - start) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = arrayToBST(nums, start, mid - 1);
        root.right = arrayToBST(nums, mid + 1, end);

        return root;
    }

}

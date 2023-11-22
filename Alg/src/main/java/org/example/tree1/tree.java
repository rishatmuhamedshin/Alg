package org.example.tree1;

import org.example.stack.SimpleQueue;
import org.example.stack.SimpleStack;

public class tree {
    public static void main(String[] args) {
        Tree root =
                new Tree(20,
                        new Tree(7,
                                new Tree(4, null, new Tree(6)), new Tree(9)),
                new Tree(35,
                        new Tree(31, new Tree(28), null),
                        new Tree(40, new Tree(38), new Tree(52))));

        System.out.println(root.sumAll());
    }

    static class Tree{
        int value;
        Tree left;
        Tree right;

        public Tree(int value, Tree left, Tree right) {
            this.value = value;
            this.left = left;
            this.right = right;
        }

        public Tree(int value) {
            this.value = value;
        }

        public int sumAll(){
            int sum = value;
            if(left != null){
                sum += left.sumAll();
            }
            if(right != null){
                sum += right.sumAll();
            }
            return sum;
        }

        public static int sumAllRecursive(Tree root){
            int sum = root.value;

            if(root.left != null){
                sum += sumAllRecursive(root.left);
            }

            if(root.right != null){
                sum += sumAllRecursive(root.right);
            }

            return sum;
        }
        public static int sumDeepWithStack(Tree root){

            SimpleStack<Tree> stack = new SimpleStack<>();
            stack.push(root);

            int sum = 0;

            while(!stack.isEmpty()){
                Tree node = stack.pop();
                sum += node.value;

                if(node.left != null){
                    stack.push(node.left);
                }
                if(node.right != null){
                    stack.push(node.left);
                }
            }

            return sum;

        }
        public static int sumWidthWithQueue(Tree root){

            SimpleQueue<Tree> queue = new SimpleQueue<>();
            queue.add(root);

            int sum = 0;

            while(!queue.isEmpty()){
                Tree node = queue.remove();
                sum += node.value;

                if(node.left != null){
                    queue.add(node.left);
                }
                if(node.right != null){
                    queue.add(node.left);
                }
            }

            return sum;

        }


    }
}

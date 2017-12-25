package com.victor.StacksAndQueues;

import com.victor.StacksAndQueues.base.LinkedStack;

/**
 * Created by Victor on 12/25/17.
 */
public class HanoiTowers {


    class Tower<E extends Comparable> {

        private LinkedStack<E> disks;
        private int index;

        public Tower(int index) {
            this.index = index;
            disks = new LinkedStack<>();
        }

        public int getIndex() {
            return index;
        }

        public void addDisk(E disk) {
            if (!disks.isEmpty() && disks.peek().compareTo(disk) <= 0) {
                System.out.println("Error placing disk: " + disk);
            } else
                disks.push(disk);
        }

        public void moveTopToTower(Tower<E> destinationTower) {
            E top = disks.pop();
            destinationTower.addDisk(top);
            System.out.println(" Move disk: " + top + " from " + getIndex() + " to " + destinationTower.getIndex());
        }

        /**
         * To solve this problem we need to divide it into smaller problems.
         * Take a look at this example
         * We have 3 towers. All the disks are in the first Tower and we need to move them all to TowerC.
         * Since we can't place bigger disk on top of lower let's devide this problem into smaller ones.
         * <p>
         * TowerA(disks=4)    TowerB ( 0 )          TowerC( 0 )
         * <p>
         * The last step in bringing all 4 disks to TowerC would be to have the Biggest disk at the bottom of TowerC in order to have this,
         * we need to move 3 disks to Tower B and the last one to TowerC
         * <p>
         * TowerA( 0 )    TowerB ( 3 )          TowerC( 1 )
         * <p>
         * Looking further in order to bring the largest disk from TowerB to TowerC we need to move all smaller to TowerA.
         * This is how we build our recursive thinking.
         */

        public void moveDisks(int n, Tower<E> destinationTower, Tower<E> auxTower) {

            if (n == 0)
                return;

            moveDisks(n - 1, auxTower, destinationTower);
            moveTopToTower(destinationTower);
            auxTower.moveDisks(n - 1, destinationTower, this);
        }

    }
}

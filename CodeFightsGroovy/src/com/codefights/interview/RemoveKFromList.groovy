// Definition for singly-linked list:
// class ListNode<T> {
//   T value;
//   ListNode<T> next;
//
//   ListNode(T x) {
//     this.value = x;
//     this.next = null;
//   }
// }
//
def removeKFromList(l, k) {
   def L = []
   while(l){
      L << l.value
      l = l.next
   }
   L - k
}

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
def isListPalindrome(l) {
    def r = []
    while(l){
        r << l.value
        l = l.next
    }
    r ? r == r[-1..0] : 1
}

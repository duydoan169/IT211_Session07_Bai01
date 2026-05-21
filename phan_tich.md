Việc lặp logic đo thời gian vi phạm những quy tắc sau:
Vi phạm SRP (Single Responsibility Principle) tức là một class chỉ nên làm một việc thôi.
Nhưng ở đây TransactionService vừa phải lo xử lý nghiệp vụ thanh toán, vừa phải tự lo 
việc ghi log thời gian. Hai việc hoàn toàn khác nhau mà nhét vào một chỗ.

Vi phạm DRY (Don't Repeat Yourself) cái đoạn startTime, endTime này sẽ phải 
copy paste vào mọi method khác trong project. Sau này có 50 method thì sửa logic 
log là sửa 50 chỗ, rất dễ sót.

Code Tangling là khi logic nghiệp vụ chính bị trộn lẫn với logic phụ như logging, security.
Đọc code khó hiểu hơn vì phải lọc ra đâu là code thật, đâu là code log.

Giải pháp đúng ở đây là dùng AOP (Aspect Oriented Programming). 
Thay vì chèn code log vào từng method, mình tách hẳn phần log ra một chỗ riêng gọi là Aspect.
Spring sẽ tự động chạy cái Aspect đó mỗi khi có method nào trong package service được gọi.
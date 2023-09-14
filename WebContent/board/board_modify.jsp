<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<jsp:include page="../include/header.jsp"/>

<div class="virtual-box"></div>
<div class="container">
	<div class="row">
		<div class="col-md-offset-2 col-md-8">
			<div class="panel">
				<div class="panel-heading text-white" align="center" style="background: #F8F8FF;">
					<h2>게시글 수정 페이지</h2>
				</div>	
					<div class="panel-body">
						<form action="update.board" method="post">
							<input type="hidden" name="bId" value="${modify_board.boardId }" >
							<div class="form-group">
								<label for="writer" hidden>작성자</label>
								<input id="writer" name="bWriter" value="${modify_board.writer }" 
								type="text" class="form-control" placeholder="작성자" readonly>
							</div>
			
						<div class="form-group">
							<label for="title" hidden>글제목</label>
							<input id="title" name="bTitle" type="text" class="form-control" value="${modify_board.title }">
						</div>
			
					<div class="form-group">
						<label for="content" hidden>글내용</label>
						<textarea id="content" name="bContent" class="form-control" rows="5">${modify_board.content }</textarea> 
					</div>
					
					
					<div>
							<button type="submit" class="btn btn-primary form-control" onclick="return confirm('수정하시겠습니까?')">수정</button>
							<button type="button" class="btn btn-danger form-control" onclick="location.href='list.board'">취소</button>
						</div>
			
						</form>
					</div>
			</div>
		</div>
	</div>
</div>
</body>	
</html>
			


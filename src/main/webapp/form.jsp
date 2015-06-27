<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<form method="post" action="simpan">
	<table>
	<tr>
	<td>nama :</td>
	<td><input type="text" name="nama"></td>
	</tr>
	<tr>
	<td>alamat :</td>
	<td><input type="text" name="alamat"></td>
	</tr>
	<tr></tr>
	<tr></tr>
	<tr>
	<td></td>
	<td>
	<input type="submit"  name="act" value="save">
	<input type="submit"  name="act" value="update">
	<input type="submit"  name="act" value="delete">
	</td>
	</tr>
	</table>
</form>
 <br/>
	 <table border="1px">
            <thead>
              <tr>
              <th>Nama</th>
              <th>Alamat</th>
              </tr>
            </thead>
            <tbody>
                <c:forEach items="${pegawais}" var="pegawai">
                    <tr>
                        <td>${pegawai.nama}</td>
                        <td>${pegawai.alamat}</td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
</body>
</html>
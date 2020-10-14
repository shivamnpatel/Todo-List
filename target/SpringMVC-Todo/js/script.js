
// Date picker
$(function(){
	$('#targetDate').datepicker({
    format: 'dd/mm/yyyy'
});
});
  
function deleteTodo()
{
	if(confirm('Are you sure you want to delete?'))
	{
		return true;
	}
	return false;
}
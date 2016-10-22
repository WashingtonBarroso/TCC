//dateformater
function dateFormatter(date){
	return (date) ? moment(date).format('DD/MM/YYYY HH:mm') : undefined;
}
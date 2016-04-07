app.service('globalService', function(){
	
	/*
	 * Exibir mensagens temporizadas em <div> 
	 */
    this.showMensage = function(div, msg, _type){
    	var _icon = '';
    	var _class = 'alert-info';
    	
    	switch(_type) {
	        case 'success':
	        	_icon = 'check';
	        	_class = 'alert-success';
	            break;
	        case 'warning':
	        	_icon = 'warning';
	        	_class = 'alert-warning';
	        	break;        
	        case 'error':
	        	_type = 'danger';
	        	_class = 'alert-danger';
	        	_icon = 'warning';
	        case 'danger':
	        	_icon = 'warning';
	        	_class = 'alert-danger';
	        case 'info':
	        	_icon = 'user';
	        default:
	        	_icon = '';
    	}    	
    	jQuery('#'+div).hide();
    	jQuery('#'+div).empty();
    	jQuery('#'+div).removeClass();
    	jQuery('#'+div).addClass('alert '+_class+' alert-dismissable');    	
    	jQuery('#'+div).append( "<span>"+msg+"</span>" )    	
    	jQuery('#'+div).show(300).delay(3000).hide(300);    	
    };
    
    /*
	 * Obter uma instancia para armazenamento local em LocalStorage 
	 */
    this.getLocalStorage = function getLocalStorage() {
	    try {
	        if(window.localStorage ) return window.localStorage;            
	    }	
	    catch (e)
	    {
	        return undefined;
	    }
    }
    
    /*
	 * Obter uma instancia para armazenamento local em LocalStorage 
	 */
    this.setBootstrapTableEvent = function(tableId, type, func){
    	switch(type){
	    	case 'onAll':
	    		var all = func;
	    		break;
    		case 'onClickRow':
    			var clickRow = func;
    			break;
    		case 'onDblClickRow':
    			var doubleClickRow = func;
    			break;
    		case 'onClickCell':
    			var clickCell = func;
    			break;
    		case 'onDblClickCell':
    			var doubleClickCell = func;
    			break;
    		case 'onSort':
    			var sort = func;
    			break;
    		case 'onCheck':
    			var check = func;
    			break;
    		case 'onUncheck':
    			var uncheck = func;
    			break;
    		case 'onCheckAll':
    			var checkAll = func;
    			break;
    		case 'onUncheckAll':
    			var uncheckAll = func;
    			break;
    		case 'onCheckSome':
    			var checkSome = func;
    			break;
    		case 'onUncheckSome':
    			var uncheckSome = func;
    			break;
    		case 'onLoadSuccess':
    			var loadSuccess = func;
    			break;
    		case 'onLoadError':
    			var loadError = func;
    			break;
    		case 'onColumnSwitch':
    			var columnSwitch = func;
    			break;
    		case 'onColumnSearch':
    			var columnSearch = func;
    			break;
    		case 'onPageChange':
    			var pageChange = func;
    			break;
    		case 'onSearch':
    			var search = func;
    			break;
    		case 'onToggle':
    			var toggle = func;
    			break;
    		case 'onPreBody':
    			var preBody = func;
    			break;
    		case 'onPostBody':
    			var postBody = func;
    			break;
    		case 'onPostHeader':
    			var postHeader = func;
    			break;
    		case 'onExpandRow':
    			var expandRow = func;
    			break;
    		case 'onCollapseRow':
    			var collapseRow= func;
    			break;
    		case 'onRefreshOptions':
    			var refreshOptions = func;
    			break;
    		case 'onResetView':
    			var resetView = func;
    			break;
    	}  
    	
    	jQuery(function(){
    		jQuery('#'+tableId)
    			.on('all.bs.table', function (e, name, args) {
    				if (all) all(e, name, args);
    	        })
    	        .on('click-row.bs.table', function (e, row, $element) {
    	        	if (clickRow) clickRow(e, row, $element);
    	        })
    	        .on('dbl-click-row.bs.table', function (e, row, $element) {
    	        	if (doubleClickRow) doubleClickRow(e, row, $element);
    	        })
    	        .on('click-cell.bs.table', function (e, field, value, row, $element) {
    	        	if (clickCell) clickCell(e, field, value, row, $element);
    	        })
    	        .on('dbl-click-cell.bs.table', function (e, field, value, row, $element) {
    	        	if (doubleClickCell) doubleClickCell(e, field, value, row, $element);
    	        })
    	        .on('sort.bs.table', function (e, name, order) {
    	        	if (sort) sort(e, name, order);
    	        })
    	        .on('check.bs.table', function (e, row, $element) {
    	        	if (check) check(e, row, $element);
    	        })
    	        .on('uncheck.bs.table', function (e, row, $element) {
    	        	if (uncheck) uncheck(e, row, $element);
    	        })
    	        .on('check-all.bs.table', function (e, rows) {
    	        	if (checkAll) checkAll(e, rows);
    	        })
    	        .on('uncheck-all.bs.table', function (e, rows) {
    	        	if (uncheckAll) uncheckAll(e, rows);
    	        })
    	        .on('check-some.bs.table', function (e, rows) {
    	        	if (checkSome) checkSome(e, rows);
    	        })
    	        .on('uncheck-some.bs.table', function (e, rows) {
    	        	if (uncheckSome) uncheckSome(e, rows);
    	        })
    	        .on('load-success.bs.table', function (e, data) {
    	        	if (loadSuccess) loadSuccess(e, data);
    	        })
    	        .on('load-error.bs.table', function (e, status, res) {
    	        	if (loadError) loadError(e, status, res);
    	        })
    	        .on('column-switch.bs.table', function (e, field, checked) {
    	        	if (columnSwitch) columnSwitch(e, field, checked);
    	        })
    	        .on('column-search.bs.table', function (e, field, text) {
    	        	if (columnSearch) columnSearch(e, field, text);
    	        })
    	        .on('page-change.bs.table', function (e, number, size) {
    	        	if (pageChange) pageChange(e, number, size);
    	        })
    	        .on('search.bs.table', function (e, text) {
    	        	if (search) search(e, text);
    	        })
	    		.on('toggle.bs.table', function (e, cardView) {
	    			if (toggle) toggle(e, cardView);
	    		})
	    		.on('pre-body.bs.table', function (e, data) {
	    			if (preBody) preBody(e, data);
	    		})
	    		.on('post-body.bs.table', function (e, none) {
	    			if (postBody) postBody(e, none);
	    		})
	    		.on('post-header.bs.table', function (e, none) {
	    			if (postHeader) postHeader(e, none);
	    		})
	    		.on('expand-row.bs.table', function (e, index, row, $detail) {
	    			if (expandRow) expandRow(e, index, row, $detail);
	    		})
	    		.on('collapse-row.bs.table', function (e, index, row) {
	    			if (collapseRow) collapseRow(e, index, row);
	    		})
	    		.on('refresh-options.bs.table', function (e, options) {
	    			if (refreshOptions) refreshOptions(e, options);
	    		})
	    		.on('reset-view.bs.table', function (e) {
	    			if (resetView) resetView(e);
	    		});
        });    	
    }    
});
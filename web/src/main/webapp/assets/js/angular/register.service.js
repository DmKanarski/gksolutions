angular
    .module('indexModule')
    .factory('Register', ['$resource',
        function ($resource) {
            "use strict";
            var header = $("meta[name='X-CSRF-TOKEN']").attr("content");
            return $resource('users', {},
                {
                    query: {
                        method: 'POST',
                        headers: {
                            'X-CSRF-TOKEN': header
                        },
                        isArray: true
                    }
                });
        }
    ]);
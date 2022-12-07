﻿using MediatR;
using PGK.Application.App.Department.Queries.GetDepartmentList;
using System.ComponentModel.DataAnnotations;

namespace PGK.Application.App.Department.Commands.UpdateDepartment
{
    public class UpdateDepartmentCommand : IRequest<DepartmentDto>
    {
        [Required] public int DepartmentId { get; set; }

        [Required] public string Name { get; set; } = string.Empty;

        [Required] public int DepartmentHeadId { get; set; }
    }
}
